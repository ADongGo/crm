package cn.offcn.controller.employee;

import cn.offcn.entity.*;
import cn.offcn.mapper.EmployeeMapper;
import cn.offcn.service.employee.EmployeeService;
import cn.offcn.utils.OAResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.sql.SQLOutput;
import java.util.List;

@Controller
@RequestMapping("/emp")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @RequestMapping("/{page}")
    public String forwardPage(@PathVariable("page") String page){

        return "system/"+page;
    }

    @ResponseBody
    @RequestMapping("/getEmployeeByPositionName")
    public List<Employee> getEmployeeByPositionName(String positionName){
        return employeeService.getEmployeeByPositionName(positionName);
    }

    @ResponseBody
    @RequestMapping("/getAllProject")
    public OAResult getAllProject(){

        return null;
    }
    @ResponseBody
    @RequestMapping("/getEmployeeByLikePositionName")
    public List<Employee> getEmployeeByLikePositionName(String positionName){

        return employeeService.getEmployeeByLikePositionName(positionName);
    }

    @ResponseBody
    @RequestMapping("/person/getEmloyeeArchives")
    public Employee getEmloyeeArchives(HttpSession session){

        Employee employee = (Employee)session.getAttribute("activeUser");
        return employeeService.getEmloyeeArchives(employee.getEid());
    }

    @ResponseBody
    @RequestMapping("/email/getEmployeeNoLogin")
    public List<Employee> getEmployeeNoLogin(HttpSession session){

        Employee employee = (Employee)session.getAttribute("activeUser");
        return employeeService.getEmployeeNoLogin(employee.getEid());
    }

    @ResponseBody
    @RequestMapping("/getEmployeeAllInfo")
    public List<Employee> getEmployeeAllInfo(){

        return employeeService.getEmployeeAllInfo();
    }

    @ResponseBody
    @RequestMapping("/getPosition")
    public List<Position> getPosition(){

        return employeeService.getPosition();
    }

    @ResponseBody
    @RequestMapping("/getLevel")
    public List<Level> getLevel(){

        return employeeService.getLevel();
    }
    @ResponseBody
    @RequestMapping("/getDept")
    public List<Dept> getDept(){

        return employeeService.getDept();
    }

    @ResponseBody
    @RequestMapping("/addEmp")
    public OAResult addEmp(Employee employee, int roleFk, MultipartFile personPic){

        return employeeService.addEmp(employee,roleFk,personPic);
    }

    @ResponseBody
    @RequestMapping("/deleteEmployeeById")
    public OAResult deleteEmployeeById(int eid){

        return employeeService.deleteEmployeeById(eid);
    }

    @RequestMapping("/getEmployeeById")
    public String getEmployeeById(int eid, Model model){

        Employee employee = employeeService.getEmployeeById(eid);
        List<Dept> deptList = employeeService.getUserDept();
        List<Level> levelList = employeeService.getUserLevel();
        List<Position> positionList = employeeService.getUserPostion();
        List<Role> roleList = employeeService.getUserRole();
        model.addAttribute("employee",employee);
        model.addAttribute("deptList",deptList);
        model.addAttribute("levelList",levelList);
        model.addAttribute("positionList",positionList);
        model.addAttribute("roleList",roleList);
        return "system/user-edit";
    }

    @ResponseBody
    @RequestMapping("/updateEmployeeById")
    public OAResult updateEmployeeById(Employee employee,int roleFk,MultipartFile personPic){

        return employeeService.updateEmployeeById(employee,roleFk,personPic);
    }

    @ResponseBody
    @RequestMapping("/updatePassword")
    public OAResult updatePassword(HttpSession session,String oldPassword,String newPassword,String conPassword){

        Employee employee = (Employee)session.getAttribute("activeUser");
        return employeeService.updatePassword(employee,oldPassword,newPassword,conPassword);
    }
}
