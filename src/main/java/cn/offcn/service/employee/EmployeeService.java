package cn.offcn.service.employee;

import cn.offcn.entity.*;
import cn.offcn.utils.OAResult;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.util.List;


public interface EmployeeService {

    /**
     * 通过职位查询员工
     * @param positionName
     * @return
     */
    public List<Employee> getEmployeeByPositionName(String positionName);

    /**
     * 通过职位模糊查询员工列表
     * @param positionName
     * @return
     */
    public List<Employee> getEmployeeByLikePositionName(String positionName);

    /**
     * 查询员工的所有信息
     * @param eid
     * @return
     */
    public Employee getEmloyeeArchives(int eid);

    /**
     * 查询除了登录者以外的员工
     * @return
     */
    public List<Employee> getEmployeeNoLogin(int eid);

    public List<Employee> getEmployeeAllInfo();

    public List<Position> getPosition();

    public List<Dept> getDept();

    public List<Level> getLevel();

    /**
     * 保存Employee
     * @param employee
     * @param roleFk
     * @param personPic
     * @return
     */
    public OAResult addEmp(Employee employee, int roleFk, MultipartFile personPic);

    /**
     * 根据eid删除员工信息
     * @param eid
     * @return
     */
    public OAResult deleteEmployeeById(int eid);

    /**
     * 通过eid获取employee对象
     * @param eid
     * @return
     */
    public Employee getEmployeeById(int eid);

    public List<Position> getUserPostion();
    public List<Level> getUserLevel();
    public List<Dept> getUserDept();
    public List<Role> getUserRole();

    /**
     * 更新employee
     * @param employee
     * @param roleFk
     * @return
     */
    public OAResult updateEmployeeById(Employee employee,int roleFk,MultipartFile personPic);

    /**
     * 修改密码
     * @param employee
     * @param oldPassword
     * @param newPassword
     * @param conPassword
     * @return
     */
    public OAResult updatePassword(Employee employee, String oldPassword, String newPassword, String conPassword);

}
