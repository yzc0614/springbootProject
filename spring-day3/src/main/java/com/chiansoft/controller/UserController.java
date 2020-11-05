package com.chiansoft.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Arrays;

@Controller
public class UserController {

    @RequestMapping("/test")
    public String test(Model model){
        model.addAttribute("msg","hello world");
        model.addAttribute("slist", Arrays.asList("a","b","c"));
        return "index";
    }
}
