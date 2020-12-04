package cn.offcn.controller.project;

import cn.offcn.entity.Attachment;
import cn.offcn.service.project.AttachmentService;
import cn.offcn.utils.OAResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.mail.Multipart;
import java.util.List;

@Controller
@RequestMapping("/attachment")
public class AttachmentController {

    @Autowired
    private AttachmentService attachmentService;

    @ResponseBody
    @RequestMapping("/save")
    public OAResult saveAttachment(Attachment attachment, MultipartFile attachmentFile){

        return attachmentService.saveAttachment(attachment,attachmentFile);
    }

    @RequestMapping("/queryAttachments")
    public String queryAttachments(Model model){
        List<Attachment> attachments = attachmentService.queryAttachments();
        model.addAttribute("attachments",attachments);
        return "project/project-file";
    }

    @RequestMapping("/download")
    public ResponseEntity<byte[]> downLoadAttachmentFile(int id)throws  Exception{

        return attachmentService.downLoadAttachmentFile(id);

    }

    @ResponseBody
    @RequestMapping("/exportData2Excle")
    public OAResult exportData2Excle(){

        return attachmentService.exportData2Excle();
    }
}
