package com.chinasoft.springbootjpa.controller;

import com.chinasoft.springbootjpa.dao.UserDao;
import com.chinasoft.springbootjpa.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserDao userDao;

    @RequestMapping("/toadd")
    public String toAdd(){
        return "add";
    }

    @GetMapping("/getAll")
    public ModelAndView getAllUsers(){
        ModelAndView mav = new ModelAndView();
        List<User> ulist = userDao.findAll();
        mav.addObject("ulist",ulist);
        mav.setViewName("index");
        return mav;
    }

    @GetMapping("/delete")
    public String deleteUser(Integer uid){
        userDao.deleteById(uid);
        return "redirect:/user/getAll";
    }

    @PostMapping("/add")
    public String addUser(User u){
        System.out.println(u);
        userDao.save(u);
        return "redirect:/user/getAll";
    }

    @GetMapping("/findone")
    public ModelAndView findOne(Integer uid){
        ModelAndView mav = new ModelAndView();
        User user = userDao.findByUid(uid);
        mav.addObject("user",user);
        mav.setViewName("update");
        return mav;
    }

    @PostMapping("/update")
    public String updateUser(User u){
        userDao.save(u);
        return "redirect:/user/getAll";
    }
}
