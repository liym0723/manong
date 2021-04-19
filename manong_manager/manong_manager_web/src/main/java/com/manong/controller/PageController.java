package com.manong.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PageController {

    // 页面管理控制器
    @RequestMapping("/{page}")
    public String requestPage(@PathVariable String page){
        return page;
    }

    @RequestMapping("/")
    public String RequestIndex(){
        return "index";
    }
}
