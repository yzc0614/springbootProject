package com.chinasoft.controller;

import com.chinasoft.service.AysncService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TaskController {

    @Autowired
    AysncService aysncService;

    @GetMapping("/")
    public String async() throws InterruptedException {
        aysncService.testAsync();
        return "ok";
    }
}
