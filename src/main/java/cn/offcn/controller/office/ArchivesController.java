package cn.offcn.controller.office;

import cn.offcn.entity.Archives;
import cn.offcn.entity.Employee;
import cn.offcn.service.office.ArchivesService;
import cn.offcn.utils.OAResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/office")
public class ArchivesController {
    @Autowired
    private ArchivesService archivesService;

    @RequestMapping("/archives/{page}")
    public String forward(@PathVariable("page") String page){

        return "office/"+page;
    }

    @RequestMapping("/archives/saveInfo")
    public String saveInfo(Employee employee, Archives archives){

        archivesService.saveInfo(employee,archives);
        return "main/main";
    }

    @ResponseBody
    @RequestMapping("/archives/importData")
    public OAResult importArchiveDataToDataBase(MultipartFile files){
        return archivesService.importArchiveDataToDataBase(files);
    }

    @ResponseBody
    @RequestMapping("/archives/getArchivesByEid")
    public Archives getArchivesByEid(int eid){

        return archivesService.getArchivesByEid(eid);
    }
}
