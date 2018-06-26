package com.tuzhi.boot.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class IndexController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @GetMapping("/home")
    @ResponseBody
    public String home(){
        return "Hello World!";
    }
    @GetMapping("/login")
    public String login(){
        return "login";
    }

    //页面跳转
    @GetMapping("/html/{module}")
    public String root(@PathVariable(name="module") String module){
        return module;
    }
    @GetMapping("/html/views/{module}")
    public String views(@PathVariable(name="module") String module){
        return "views/"+module;
    }

}
