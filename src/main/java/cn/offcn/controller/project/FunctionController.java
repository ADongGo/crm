package cn.offcn.controller.project;

import cn.offcn.entity.Function;
import cn.offcn.service.project.FunctionService;
import cn.offcn.utils.OAResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/function")
public class FunctionController {

    @Autowired
    private FunctionService functionService;

    @ResponseBody
    @RequestMapping("/save")
    public OAResult saveFunction(Function function){

        System.out.println(function.getFunctionname());
        return functionService.saveFunction(function);
    }

    @ResponseBody
    @RequestMapping("/getFunctionsByNoTask")
    public List<Function> getFunctionsByNoTask(int moduleId){

        return functionService.getFunctionsByNoTask(moduleId);
    }
}
