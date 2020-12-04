package cn.offcn.controller.project;

import cn.offcn.entity.Analysis;
import cn.offcn.service.project.AnalysisService;
import cn.offcn.utils.OAResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/analysis")
public class AnalysisController {

    @Autowired
    private AnalysisService analysisService;

    @ResponseBody
    @RequestMapping("/save")
    public OAResult saveAnalysis(Analysis analysis){

        return analysisService.saveAnalysis(analysis);
    }

    @ResponseBody
    @RequestMapping("/getAllAnalysis")
    public List<Analysis> getAllAnalysis(){

        return analysisService.getAllAnalysis();
    }

    @ResponseBody
    @RequestMapping("/getAnalysisById")
    public Analysis getAnalysisById(int id){

        return analysisService.getAnalysisById(id);
    }

}
