package com.chinasoft.controller;

import com.chinasoft.pojo.Admin;
import com.chinasoft.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @RequestMapping("/login")
    public String checkLogin(String account, String password, Model model, HttpSession session){
        Admin admin = adminService.selectByAccountAndPassword(account, password);
        System.out.println(admin);
        if(admin==null){
            model.addAttribute("msg","您输入的用户名或密码有误");
            return "redirect:/login.html";
        }
        session.setAttribute("admin",admin);
        return "redirect:/index.html";
    }

}
