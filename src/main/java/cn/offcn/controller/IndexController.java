package cn.offcn.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller

public class IndexController {

    @RequestMapping("/main/{page}")
    public String mainIndex(@PathVariable("page")String page){

        return "main/"+page;
    }
}
