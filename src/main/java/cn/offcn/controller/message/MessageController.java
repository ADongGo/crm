package cn.offcn.controller.message;

import cn.offcn.entity.Msg;
import cn.offcn.service.message.MessageService;
import cn.offcn.utils.OAResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/message")
public class MessageController {

    @Autowired
    private MessageService messageService;

    @RequestMapping("/{page}")
    public String forward(@PathVariable("page")String page){
        return "message/"+page;
    }

    @ResponseBody
    @RequestMapping("/sendMsg")
    public OAResult sendMsg(Msg msg, HttpSession session)throws Exception{

        return messageService.sendMsg(msg,session);
    }
}
