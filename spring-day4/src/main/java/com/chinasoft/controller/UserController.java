package com.chinasoft.controller;

import com.chinasoft.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/user")
public class UserController {

    @RequestMapping("/")
    public String login(){
        return "login";
    }

    @RequestMapping("/login")
    public String checkLogin(@RequestParam("username") String username, @RequestParam("password") String password,
                             HttpSession session, Model model){
        if(username.equals("wzx")&&password.equals("123")){
            User u = new User(username,password);
            session.setAttribute("user",u);
            return "redirect:../index.html";
        }
        model.addAttribute("msg","用户名或密码错误");
        return "login";
    }
}
