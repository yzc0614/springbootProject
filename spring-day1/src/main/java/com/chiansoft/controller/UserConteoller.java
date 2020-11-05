package com.chiansoft.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserConteoller {

    @RequestMapping("/test")
    public String test(){
        return "hello world";
    }
}
