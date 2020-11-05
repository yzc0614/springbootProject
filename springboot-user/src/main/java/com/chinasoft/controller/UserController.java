package com.chinasoft.controller;

import com.chinasoft.pojo.User;
import com.chinasoft.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/getAll")
    public String getAll(Model model){
        List<User> ulist = userService.getAllUser();
        model.addAttribute("ulist",ulist);
        return "user/member-list";
    }
}
