package cn.offcn.controller.message;

import cn.offcn.entity.Employee;
import cn.offcn.entity.Evaluate;
import cn.offcn.entity.Forumpost;
import cn.offcn.service.message.ForumService;
import cn.offcn.service.project.FunctionService;
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
@RequestMapping("/forumpost")
public class ForumController {

    @Autowired
    private ForumService forumService;

    @RequestMapping("/{page}")
    public String forwardPage(@PathVariable("page")String page){
        return "message/"+page;
    }

    @RequestMapping("/add")
    public String addForumpost(Forumpost forumpost, HttpSession session){

        Employee employee = (Employee)session.getAttribute("activeUser");
        forumpost.setEmpfk3(employee.getEid());
        forumService.addForumpost(forumpost);
        return "redirect:/forumpost/show";
    }

    @RequestMapping("/show")
    public String showForumByEid(HttpSession session, Model model){

        Employee employee = (Employee)session.getAttribute("activeUser");
        List<Forumpost> forumposts = forumService.showForumByEid(employee.getEid());
        model.addAttribute("forumposts",forumposts);
        return "message/forum";
    }

    @RequestMapping("/getForumpostByFroumId")
    public String getForumpostByFroumId(int forumid,Model model){

        Forumpost forumpost = forumService.getForumpostByFroumId(forumid);
        model.addAttribute("forum",forumpost);
        return "message/forum-reply";
    }

    @ResponseBody
    @RequestMapping("/forumpostTop9")
    public List<Forumpost> forumpostTop9(int flag){

        return forumService.forumpostTop9(flag);
    }

    @RequestMapping("/evaluate/add")
    public String addEvaluate(Evaluate evaluate,HttpSession session){

        Employee employee=(Employee)session.getAttribute("activeUser");
        evaluate.setEmpfk(employee.getEid());
        forumService.addEvaluate(evaluate);
        return "redirect:/forumpost/getForumpostByFroumId?forumid="+evaluate.getForumfk();
    }

    @ResponseBody
    @RequestMapping("/showYi")
    public List<Forumpost> showYi(HttpSession session){

        Employee employee = (Employee)session.getAttribute("activeUser");
        List<Forumpost> forumposts = forumService.showForumByEid(employee.getEid());

        return forumposts;
    }
}
