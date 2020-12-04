package cn.offcn.controller.office;

import cn.offcn.entity.Baoxiao;
import cn.offcn.entity.Employee;
import cn.offcn.service.office.BaoxiaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/baoxiao")
public class BaoxiaoController {
    @Autowired
    private BaoxiaoService baoxiaoService;

    @RequestMapping("/{page}")
    public String forwardPage(@PathVariable("page") String page){
        return "baoxiao/"+page;
    }

    @RequestMapping("/save")
    public String saveBaoxiao(Baoxiao baoxiao, HttpSession session){

        Employee employee = (Employee) session.getAttribute("activeUser");
        baoxiaoService.saveBaoxiao(baoxiao,employee.getEid());
        return "redirect:/baoxiao/queryBaoxiao";
    }

    @RequestMapping("/queryBaoxiao")
    public String queryBaoxiao(HttpSession session, Model model){
        Employee employee = (Employee) session.getAttribute("activeUser");
        List<Baoxiao> baoxiaos = baoxiaoService.queryBaoxiao(employee.getEid());
        model.addAttribute("baoxiaos",baoxiaos);
        return "baoxiao/mybaoxiao-base";
    }

    @RequestMapping("/getBaoxiaoByStatus/{bxstatus}")
    public String getBaoxiaoByStatus(@PathVariable("bxstatus") int bxstatus,Model model){

        List<Baoxiao> baoxiaos = baoxiaoService.getBaoxiaoByStatus(bxstatus);
        model.addAttribute("baoxiaos",baoxiaos);
        return "baoxiao/baoxiao-task";
    }

    @RequestMapping("/getBaoXiaoByBxid/{bxid}/{page}")
    public String getBaoXiaoByBxid(@PathVariable("bxid")String bxid,@PathVariable("page")String page, Model model){

        Baoxiao baoxiao = baoxiaoService.getBaoXiaoByBxid(bxid);
        model.addAttribute("baoxiao",baoxiao);
        return "baoxiao/"+page;
    }

    @RequestMapping("/approveBaoxiao")
    public String approveBaoxiao(String bxid,int bxstatus,String result,HttpSession session){
        Employee employee=(Employee)session.getAttribute("activeUser");
        baoxiaoService.approveBaoxiao(bxid,bxstatus,result,employee.getEid());
        return "redirect:/baoxiao/getBaoxiaoByStatus/1";
    }
    @RequestMapping("/updateBaoxiaoByBxid")
    public String updateBaoxiaoByBxid(Baoxiao baoxiao){

        baoxiaoService.updateBaoxiaoByBxid(baoxiao);
        return "redirect:/baoxiao/queryBaoxiao";
    }
}
