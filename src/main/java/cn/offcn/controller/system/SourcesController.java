package cn.offcn.controller.system;

import cn.offcn.entity.Employee;
import cn.offcn.entity.Sources;
import cn.offcn.service.system.SourcesService;
import cn.offcn.utils.OAResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/resource")
public class SourcesController {

    @Autowired
    private SourcesService sourcesService;

    @RequestMapping("/{page}")
    public String forwardPage(@PathVariable("page") String page, @RequestParam(value = "id", defaultValue = "1") int id, Model model) {
        model.addAttribute("id", id);
        return "system/" + page;
    }

    @ResponseBody
    @RequestMapping("/getRootSources")
    public List<Sources> getRootSources(@RequestParam(value = "pid", defaultValue = "0") int pid) {

        return sourcesService.getRootSources(pid);
    }

    @ResponseBody
    @RequestMapping("/addSources")
    public OAResult addSources(Sources sources) {

        return sourcesService.addSources(sources);
    }

    @ResponseBody
    @RequestMapping("/getOneSource")
    public Sources getOneSource(int id) {

        return sourcesService.getOneSource(id);
    }

    @ResponseBody
    @RequestMapping("/updateSource")
    public OAResult updateSource(Sources sources) {

        return sourcesService.updateSource(sources);
    }

    @ResponseBody
    @RequestMapping("/deleteSourcesById")
    public OAResult deleteSourcesById(int id) {

        return sourcesService.deleteSourcesById(id);
    }


    @ResponseBody
    @RequestMapping("/getCurrentEmployeeRoleSources")
    public List<Sources> getCurrentEmployeeRoleSources(HttpSession session, @RequestParam(value="pid",defaultValue = "1") int pid,String username){
        Employee employee=(Employee)session.getAttribute("activeUser");
        return sourcesService.getSourcesByEmployee(employee.getEid(),pid,employee.getUsername());
    }
}