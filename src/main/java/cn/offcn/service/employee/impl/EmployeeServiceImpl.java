package cn.offcn.service.employee.impl;

import cn.offcn.entity.*;
import cn.offcn.mapper.*;
import cn.offcn.service.employee.EmployeeService;
import cn.offcn.utils.OAResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;
import org.springframework.web.multipart.MultipartFile;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import javax.xml.ws.WebServiceClient;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Value("${saveDir}")
    private String saveDir;
    @Autowired
    private PositionMapper positionMapper;
    @Autowired
    private EmployeeMapper employeeMapper;
    @Autowired
    private DeptMapper deptMapper;
    @Autowired
    private LevelMapper levelMapper;
    @Autowired
    private ArchivesMapper archivesMapper;
    @Autowired
    private EmpRoleMapper empRoleMapper;
    @Autowired
    private RoleMapper roleMapper;
    @Autowired
    private JedisPool jedisPool;

    @Override
    public List<Employee> getEmployeeByPositionName(String positionName) {

        PositionExample positionExample=new PositionExample();
        PositionExample.Criteria criteria = positionExample.createCriteria();
        criteria.andNameEqualTo(positionName);
        List<Position> positionList = positionMapper.selectByExample(positionExample);
        if(positionList!=null&&positionList.size()==1){
            Position position = positionList.get(0);

            EmployeeExample employeeExample=new EmployeeExample();
            EmployeeExample.Criteria criteria1 = employeeExample.createCriteria();
            criteria1.andPFkEqualTo(position.getId());
            return employeeMapper.selectByExample(employeeExample);
        }
        return null;
    }

    @Override
    public List<Employee> getEmployeeByLikePositionName(String positionName) {
        return employeeMapper.getEmployeeByLikePositionName("%"+positionName+"%");
    }

    @Override
    public Employee getEmloyeeArchives(int eid) {
        Employee employee = employeeMapper.selectByPrimaryKey(eid);
        Position position = positionMapper.selectByPrimaryKey(employee.getpFk());
        Dept dept = deptMapper.selectByPrimaryKey(employee.getdFk());
        Level level = levelMapper.selectByPrimaryKey(employee.getlFk());

        ArchivesExample archivesExample=new ArchivesExample();
        ArchivesExample.Criteria criteria = archivesExample.createCriteria();
        criteria.andEmpFkEqualTo(eid);
        employee.setPosition(position);
        employee.setDept(dept);
        employee.setLevel(level);
        List<Archives> archives = archivesMapper.selectByExample(archivesExample);
        if(archives!=null&&archives.size()>0){
            employee.setArchives(archives.get(0));
        }
        return employee;
    }

    @Override
    public List<Employee> getEmployeeNoLogin(int eid) {

        EmployeeExample employeeExample=new EmployeeExample();
        EmployeeExample.Criteria criteria = employeeExample.createCriteria();
        criteria.andEidNotEqualTo(eid);

        return employeeMapper.selectByExample(employeeExample);
    }

    public List<Employee> getEmployeeAllInfo(){

        List<Employee> employeeList= employeeMapper.selectByExample(new EmployeeExample());
        for(Employee employee : employeeList){
            Position position= positionMapper.selectByPrimaryKey(employee.getpFk());
            employee.setPosition(position);
        }
        return employeeList;
    }

    public List<Position> getPosition(){

        return positionMapper.selectByExample(new PositionExample());
    }

    public List<Dept> getDept(){
        return deptMapper.selectByExample(new DeptExample());
    }

    public List<Level> getLevel(){
        return levelMapper.selectByExample(new LevelExample());
    }

    public OAResult addEmp(Employee employee, int roleFk, MultipartFile personPic){
        try{
            if(personPic!=null && personPic.getSize()>0){
                //上传文件的文件名
                String fileName=personPic.getOriginalFilename();
                int hashCode=fileName.hashCode();
                int d1=hashCode&0xf;
                int d2=(hashCode>>2)&0xf;
                File saveFileDir=new File(saveDir+"/"+d1+"/"+d2);
                if(!saveFileDir.exists()) saveFileDir.mkdirs();
                //防止文件重名
                fileName= UUID.randomUUID().toString()+"&"+fileName;
                File saveFile=new File(saveFileDir,fileName);
                personPic.transferTo(saveFile);

                //设置头像的地址
                employee.setPic("/pic/"+d1+"/"+d2+"/"+fileName);
            }

        }catch(Exception e){
            e.printStackTrace();
            return OAResult.ok(400,"上像上传失败");
        }
        employee.setPassword(DigestUtils.md5DigestAsHex(employee.getPassword().getBytes()));
        int i1 = employeeMapper.insert(employee);
        EmpRole empRole=new EmpRole();
        empRole.setEmpFk(employee.getEid());
        empRole.setRoleFk(roleFk);
        int i2 = empRoleMapper.insert(empRole);
        if(i1==1&&i2==1){
            return OAResult.ok(200,"保存成功");
        }
        return OAResult.ok(400,"保存失败");
    }

    @Override
    public OAResult deleteEmployeeById(int eid) {

        //删除empRole中间表
        EmpRoleExample empRoleExample=new EmpRoleExample();
        EmpRoleExample.Criteria criteria = empRoleExample.createCriteria();
        criteria.andEmpFkEqualTo(eid);
        empRoleMapper.deleteByExample(empRoleExample);
        //清除redis里数据
        Jedis jedis = jedisPool.getResource();
        Employee employee = employeeMapper.selectByPrimaryKey(eid);
        jedis.hdel("permission",employee.getUsername());
        jedis.close();
        int i = employeeMapper.deleteByPrimaryKey(eid);

        if(i==1){
            return OAResult.ok(200,"删除成功");
        }
        return OAResult.ok(200,"删除成功");
    }

    public Employee getEmployeeById(int eid){

        Employee employee = employeeMapper.selectByPrimaryKey(eid);
        Position position = positionMapper.selectByPrimaryKey(employee.getpFk());
        Level level = levelMapper.selectByPrimaryKey(employee.getlFk());
        Dept dept = deptMapper.selectByPrimaryKey(employee.getdFk());

        EmpRoleExample empRoleExample=new EmpRoleExample();
        EmpRoleExample.Criteria criteria = empRoleExample.createCriteria();
        criteria.andEmpFkEqualTo(employee.getEid());
        List<EmpRole> empRoleList = empRoleMapper.selectByExample(empRoleExample);
        if(empRoleList==null||empRoleList.size()==0){
            EmpRole empRole=new EmpRole();
            employee.setEmpRole(empRole);
        }else{
            employee.setEmpRole(empRoleList.get(0));
        }
        return employee;
    }

    @Override
    public List<Position> getUserPostion() {
        return positionMapper.selectByExample(new PositionExample());
    }

    @Override
    public List<Level> getUserLevel() {
        return levelMapper.selectByExample(new LevelExample());
    }

    @Override
    public List<Dept> getUserDept() {
        return deptMapper.selectByExample(new DeptExample());
    }

    @Override
    public List<Role> getUserRole() {
        return roleMapper.selectByExample(new RoleExample());
    }

    @Override
    public OAResult updateEmployeeById(Employee employee, int roleFk,MultipartFile personPic) {

        try{
            if(personPic!=null && personPic.getSize()>0){
                //上传文件的文件名
                String fileName=personPic.getOriginalFilename();
                int hashCode=fileName.hashCode();
                int d1=hashCode&0xf;
                int d2=(hashCode>>2)&0xf;
                File saveFileDir=new File(saveDir+"/"+d1+"/"+d2);
                if(!saveFileDir.exists()) saveFileDir.mkdirs();
                //防止文件重名
                fileName= UUID.randomUUID().toString()+"&"+fileName;
                File saveFile=new File(saveFileDir,fileName);
                personPic.transferTo(saveFile);
                //设置头像的地址
                employee.setPic("/pic/"+d1+"/"+d2+"/"+fileName);
            }
        }catch(Exception e){
            e.printStackTrace();
            return OAResult.ok(400,"上像上传失败");
        }
        String password=employee.getPassword();
        System.out.println("1"=="1");
        if(password.equals("")||password==null){

            Employee oldEmployee = employeeMapper.selectByPrimaryKey(employee.getEid());
            employee.setPassword(oldEmployee.getPassword());
        }else{
            employee.setPassword(DigestUtils.md5DigestAsHex(password.getBytes()));
        }
        int i = employeeMapper.updateByPrimaryKey(employee);
        EmpRole empRole=new EmpRole();
        empRole.setRoleFk(roleFk);
        empRole.setEmpFk(employee.getEid());
        //先删除原有中间表数据
        EmpRoleExample empRoleExample=new EmpRoleExample();
        EmpRoleExample.Criteria criteria = empRoleExample.createCriteria();
        criteria.andEmpFkEqualTo(employee.getEid());
        empRoleMapper.deleteByExample(empRoleExample);
        int ii = empRoleMapper.insert(empRole);
        //清除redis里数据
        Jedis jedis = jedisPool.getResource();
        jedis.hdel("permission",employee.getUsername());
        jedis.close();
        if(i==1&&ii==1){
            return OAResult.ok(200,"更新成功");
        }
        return OAResult.ok(200,"更新失败");
    }

    @Override
    public OAResult updatePassword(Employee employee, String oldPassword, String newPassword, String conPassword) {
        if(newPassword.equals(conPassword)){
            oldPassword=DigestUtils.md5DigestAsHex(oldPassword.getBytes());
            newPassword=DigestUtils.md5DigestAsHex(newPassword.getBytes());
            if(oldPassword.equals(employee.getPassword())){
                employee.setPassword(newPassword);
                int i = employeeMapper.updateByPrimaryKey(employee);
                if(i==1){
                    return OAResult.ok(200,"修改密码成功");
                }
            }
            return OAResult.ok(400,"输入原始密码错误");
        }
        return OAResult.ok(400,"输入新旧密码不一致");
    }


}
