package cn.offcn.controller.message;

import cn.offcn.entity.Email;
import cn.offcn.utils.OAResult;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/message/email")
public class EmailController {

    @RequestMapping("/{page}")
    public String forwardPage(@PathVariable("page")String page){

        return "message/"+page;
    }

    @ResponseBody
    @RequestMapping("/email/sendEmail")
    public OAResult sendEmail(Email email, String reemp, MultipartFile file, HttpSession session){


        return null;
    }
}
