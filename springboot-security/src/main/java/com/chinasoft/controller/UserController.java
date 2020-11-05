package com.chinasoft.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserController {

    @RequestMapping({"/","/index"})
    public String home(){
        return "index";
    }

    @RequestMapping("level1/{id}")
    public String level1(@PathVariable("id") int id){
        return "/views/level1/level"+id;
    }

    @RequestMapping("level2/{id}")
    public String level2(@PathVariable("id") int id){
        return "/views/level2/level"+id;
    }
}
