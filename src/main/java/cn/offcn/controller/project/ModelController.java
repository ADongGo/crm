package cn.offcn.controller.project;

import cn.offcn.entity.Module;
import cn.offcn.service.project.ModelService;
import cn.offcn.utils.OAResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/model")
public class ModelController {

    @Autowired
    private ModelService modelService;

    @ResponseBody
    @RequestMapping("/save")
    public OAResult saveModel(Module module){


        return modelService.saveModel(module);
    }

    @ResponseBody
    @RequestMapping("/getModelByAnalysis")
    public List<Module> getModelByAnalysis(int analysisId){

        return modelService.getModelByAnalysis(analysisId);
    }
}
