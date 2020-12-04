package cn.offcn.controller.office;

import cn.offcn.entity.Notice;
import cn.offcn.service.office.NoticeService;
import cn.offcn.utils.OAResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/office")
public class NoticeController {

    @Autowired
    private NoticeService noticeService;

    @RequestMapping("/notice/{page}")
    public String forward(@PathVariable("page") String page){
        return "office/"+page;
    }

    @RequestMapping("/notice/add")
    public String addNotice(Notice notice){

        noticeService.addNotice(notice);
        return "office/notice/notice";
    }

    @ResponseBody
    @RequestMapping("/notice/getNotice")
    public List<Notice> getNotice(){

        return noticeService.getNotice();
    }

    @ResponseBody
    @RequestMapping("/notice/getNoticesByFlag")
    public List<Notice> getNoticesByFlag(int flag){

        return noticeService.getNoticesByFlag(flag);
    }

    @ResponseBody
    @RequestMapping("/notice/getNoticeByNid")
    public Notice getNoticeByNid(int nid){

        return noticeService.getNoticeByNid(nid);
    }
}
