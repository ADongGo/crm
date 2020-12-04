package cn.offcn.controller.duibiao;

import cn.offcn.entity.Datacollect;
import cn.offcn.entity.Employee;
import cn.offcn.entity.Indexvalue;
import cn.offcn.service.duibiao.DuiBiaoService;
import cn.offcn.utils.OAResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/duibiao")
public class DuiBiaoController {

    @Autowired
    private DuiBiaoService duiBiaoService;

    @RequestMapping("/forward/{page}")
    public String forwardDuiBiaoPage(@PathVariable("page") String page){

        return "duibiao/"+page;
    }

    //异步加载我们企业的名称
    @RequestMapping("/getInfoGroup")
    @ResponseBody
    public List<Datacollect> getInfoGroup() {

        return duiBiaoService.getInfoGroup();
    }

    @RequestMapping("/getOneByCname")
    @ResponseBody
    public Map<String, Object> getOneByCname(Datacollect datacollect){
        Map<String, Object> map = new HashMap<>();
        List<Datacollect> list = duiBiaoService.getInfoBydacname(datacollect.getDacname());
        Datacollect one = duiBiaoService.getOneByCname(datacollect);
        map.put("one", one);
        map.put("list", list);
        return map;
    }

    @RequestMapping("/getOneBydaid")
    @ResponseBody
    public Map<String, Object> getOneBydaid(Integer daid) {
        Datacollect datacollect = duiBiaoService.geOneByDaid(daid);
        Map<String, Object> map = new HashMap<>();
        List<Datacollect> list = duiBiaoService.getInfoBydacname(datacollect.getDacname());
        map.put("one", datacollect);
        map.put("list", list);
        return map;
    }

    //添加指标计划

    @RequestMapping("saveIndexValueInfo")
    public String saveIndexValueInfo(Indexvalue indexvalue, MultipartFile files, HttpServletRequest request) throws Exception {
        Employee employee=(Employee)request.getSession().getAttribute("activeUser");
        indexvalue.setEmpFk5(employee.getEid());
        //存放的位置
        String path = "E:\\attachment\\file\\";
        if (files!=null && files.getSize()>0) {
            path += files.getOriginalFilename();
            File file = new File(path);
            files.transferTo(file);
        }
        indexvalue.setInFile(path);

        OAResult oaResult = duiBiaoService.saveIndexValueInfo(indexvalue);
        if(oaResult.getStatus()==200){
            return "redirect: "+request.getContextPath()+"/duibiao/forward/indexvalue-base";
        }
        request.setAttribute("message","数据保存失败");
        return "error/error";
    }

    @RequestMapping("showPng")
    @ResponseBody
    public List<Datacollect> showPng(){

        return  duiBiaoService.getInfoBydacname("浪潮集团");
    }

    @RequestMapping("/showDatacollect")
    public String showDatacollect(Model model){

        List<Datacollect> datacollectList = duiBiaoService.showDatacollect();
        model.addAttribute("datacollectList",datacollectList);
        return "duibiao/duibiao-base";
    }

    @RequestMapping("/showIndexvalue")
    public String showIndexvalue(Model model){

        List<Indexvalue> indexvalueList = duiBiaoService.showIndexvalue();
        model.addAttribute("indexvalueList",indexvalueList);
        return "duibiao/indexvalue-base";
    }
}
