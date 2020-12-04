package cn.offcn.controller.office;

import cn.offcn.entity.Employee;
import cn.offcn.entity.Task;
import cn.offcn.service.office.TaskService;
import cn.offcn.utils.OAResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/office")
public class TaskController {

    @Autowired
    private TaskService taskService;

    @RequestMapping("/{page}")
    public String forwardPage(@PathVariable("page") String page){

        return "office/"+page;
    }

    @ResponseBody
    @RequestMapping("/task/save")
    public OAResult saveTask(Task task, HttpSession session){
        Employee employee=(Employee)session.getAttribute("activeUser");
        task.setEmpFk(employee.getEid());
        return taskService.saveTask(task);
    }

    @RequestMapping("/task/getTaskByEmployee")
    public String getTaskByEmployee(HttpSession session, Model model){
        Employee employee=(Employee)session.getAttribute("activeUser");
        List<Task> taskList=taskService.getTaskByEmployee(employee.getEid());

        model.addAttribute("taskList",taskList);
        return "office/task";
    }
    @RequestMapping("/task/getMyTaskByEmployee")
    public String getTaskByLoginEmployee(HttpSession session, Model model){
        Employee employee=(Employee)session.getAttribute("activeUser");
        List<Task> taskList=taskService.getMyTaskEmployee(employee.getEid());

        model.addAttribute("taskList",taskList);
        return "office/task-my";
    }

    @ResponseBody
    @RequestMapping("/task/updateTaskStatus")
    public OAResult updateTaskStatus(int id,int status){

        return taskService.updateTaskStatus(id,status);
    }
}
