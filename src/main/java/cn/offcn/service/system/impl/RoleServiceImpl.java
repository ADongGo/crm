package cn.offcn.service.system.impl;

import cn.offcn.entity.*;
import cn.offcn.mapper.EmpRoleMapper;
import cn.offcn.mapper.EmployeeMapper;
import cn.offcn.mapper.RoleMapper;
import cn.offcn.mapper.RoleSourcesMapper;
import cn.offcn.service.system.RoleService;
import cn.offcn.utils.OAResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleMapper roleMapper;
    @Autowired
    private RoleSourcesMapper roleSourcesMapper;
    @Autowired
    private EmpRoleMapper empRoleMapper;
    @Autowired
    private EmployeeMapper employeeMapper;
    @Autowired
    private JedisPool jedisPool;

    @Override
    public OAResult addRole(Role role, String sourcesid) {

        int insert = roleMapper.insert(role);
        String[] sids = sourcesid.split(",");
        int count = 0;
        for (String sid : sids) {
            RoleSources roleSources = new RoleSources();
            roleSources.setSid(Integer.parseInt(sid));
            roleSources.setRoleid(role.getRoleid());
            roleSourcesMapper.insert(roleSources);
            count++;
        }
        if (insert == 1 && sids.length == count) {
            return OAResult.ok(200, "保存成功");
        }
        return OAResult.ok(400, "保存失败");
    }

    @Override
    public List<Role> getAllRole() {

        return roleMapper.selectByExample(new RoleExample());
    }

    @Override
    public OAResult deleteInfo(int roleid) {

        //先删emp_role中间表
        EmpRoleExample empRoleExample=new EmpRoleExample();
        EmpRoleExample.Criteria criteria1 = empRoleExample.createCriteria();
        criteria1.andRoleFkEqualTo(roleid);
        //清空所有带有此role的缓存
        List<EmpRole> empRoleList = empRoleMapper.selectByExample(empRoleExample);
        Jedis jedis = jedisPool.getResource();
        for(EmpRole empRole:empRoleList){
            String username=employeeMapper.selectByPrimaryKey(empRole.getEmpFk()).getUsername();
            jedis.hdel("permission",username);
        }
        jedis.close();

        empRoleMapper.deleteByExample(empRoleExample);
        //接着删除role_Sources中间表
        RoleSourcesExample roleSourcesExample = new RoleSourcesExample();
        RoleSourcesExample.Criteria criteria = roleSourcesExample.createCriteria();
        criteria.andRoleidEqualTo(roleid);
        List<RoleSources> roleSourcesList = roleSourcesMapper.selectByExample(roleSourcesExample);
        int i = roleSourcesMapper.deleteByExample(roleSourcesExample);

        if (i == roleSourcesList.size()) {
            int ii = roleMapper.deleteByPrimaryKey(roleid);
            if(ii==1){
                return OAResult.ok(200, "删除成功");
            }
        }
        return OAResult.ok(400, "删除失败");
    }

    @Override
    public Role showOneRole(int roleid) {

        return roleMapper.selectByPrimaryKey(roleid);
    }

    @Override
    public List<RoleSources> getSourcesByRoleid(int roleid) {
        
        RoleSourcesExample roleSourcesExample=new RoleSourcesExample();
        RoleSourcesExample.Criteria criteria = roleSourcesExample.createCriteria();
        criteria.andRoleidEqualTo(roleid);
        return roleSourcesMapper.selectByExample(roleSourcesExample);
    }

    public OAResult updateRole(Role role,String sourcesid){

        int rows=roleMapper.updateByPrimaryKey(role);

        RoleSourcesExample roleSourcesExample=new RoleSourcesExample();
        RoleSourcesExample.Criteria criteria = roleSourcesExample.createCriteria();
        criteria.andRoleidEqualTo(role.getRoleid());
        List<RoleSources> roleSourcesList = roleSourcesMapper.selectByExample(roleSourcesExample);
        int d = roleSourcesMapper.deleteByExample(roleSourcesExample);
        if(d==roleSourcesList.size()){
            String[] sids = sourcesid.split(",");
            int count=0;
            for(String sid:sids){
                RoleSources roleSources = new RoleSources();
                roleSources.setSid(Integer.parseInt(sid));
                roleSources.setRoleid(role.getRoleid());
                roleSourcesMapper.insert(roleSources);
                count++;
            }
            //清空所有带有此role的缓存
            EmpRoleExample empRoleExample=new EmpRoleExample();
            EmpRoleExample.Criteria criteria1 = empRoleExample.createCriteria();
            criteria1.andRoleFkEqualTo(role.getRoleid());
            List<EmpRole> empRoleList = empRoleMapper.selectByExample(empRoleExample);
            Jedis jedis = jedisPool.getResource();
            for(EmpRole empRole:empRoleList){
                String username=employeeMapper.selectByPrimaryKey(empRole.getEmpFk()).getUsername();
                jedis.hdel("permission",username);
            }
            jedis.close();

            if(count==sids.length){
                return OAResult.ok(200,"修改成功");
            }
        }
        return OAResult.ok(400,"修改失败");
    }

    public List<Role> getAllRoleByStatus(int status){

        RoleExample roleExample=new RoleExample();
        RoleExample.Criteria criteria = roleExample.createCriteria();
        criteria.andStatusEqualTo(status);
        return roleMapper.selectByExample(roleExample);
    }
}