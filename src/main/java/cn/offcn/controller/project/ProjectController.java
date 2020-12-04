package cn.offcn.controller.project;


import cn.offcn.entity.Employee;
import cn.offcn.entity.Project;
import cn.offcn.service.project.ProjectService;
import cn.offcn.utils.OAResult;
import cn.offcn.utils.PageView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/project")
public class ProjectController {

    @Value("${pageSize}")
    private int pageSize;
    @Autowired
    private ProjectService projectService;

    @RequestMapping("/{page}")
    public String forwardPage(@PathVariable("page") String page){

        return "project/"+page;
    }

    @ResponseBody
    @RequestMapping("/add")
    public OAResult addProject(Project project){

        return projectService.addProject(project);
    }


    @ResponseBody
    @RequestMapping("/getAllProject")
    public List<Project> getAllProject(){

        return projectService.getAllProject();
    }

    @ResponseBody
    @RequestMapping("/getAllProjectByNoNeed")
    public List<Project> getAllProjectByNoNeed(){

        return projectService.getAllProjectByNoNeed();
    }

    @ResponseBody
    @RequestMapping("/getAllProjectByNeed")
    public List<Project> getAllProjectByNeed(){

        return projectService.getAllProjectByNeed();
    }

    @ResponseBody
    @RequestMapping("/getAllProjectByModule")
    public List<Project> getAllProjectByModule(){

        return projectService.getAllProjectByModule();
    }

    @ResponseBody
    @RequestMapping("/getProjectByFunctionAndEid")
    public List<Project> getProjectByFunctionAndEid(HttpSession session){
        Employee employee = (Employee)session.getAttribute("activeUser");

        return projectService.getProjectByFunctionAndEid(employee.getEid());
    }

    @RequestMapping("/getProjectById")
    public String getProjectById(int pid, Model model){

        Project project = projectService.getProjectById(pid);
        model.addAttribute("project",project);
        return "project/project-base-look";
    }

    @ResponseBody
    @RequestMapping("/showProject")
    public PageView<Project> showProject(int currentPage,
                                                   @RequestParam(value="searchC",defaultValue = "0") int searchC,
                                                   String keyword,
                                                   @RequestParam(value = "orderby",defaultValue = "0") int orderby){
        System.out.println("sear:"+searchC+"==="+"keyword"+keyword+"orderby"+orderby);
        return projectService.showProject(currentPage,searchC,keyword,orderby,pageSize);
    }
}
