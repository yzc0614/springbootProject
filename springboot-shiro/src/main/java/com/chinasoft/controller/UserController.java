package com.chinasoft.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserController {

    @RequestMapping({"/","/index"})
    public String home(){
     return "index";
    }

    @RequestMapping("/login")
    public String login(){
        return "login";
    }

    @RequestMapping("/user/add")
    public String add(){
        return "add";
    }

    @RequestMapping("/user/update")
    public String update(){
        return "update";
    }

    @RequestMapping("/checkLogin")
    public String checkLogin(String username, String password, Model model){
        //拿到当前登陆对象
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(username,password);

        try {
            subject.login(token);
        }catch (UnknownAccountException e){
            model.addAttribute("msg","用户名错误");
            return "login";
        }catch (IncorrectCredentialsException e){
            model.addAttribute("msg","密码错误");
            return "login";
        }
        return "index";
    }
}
