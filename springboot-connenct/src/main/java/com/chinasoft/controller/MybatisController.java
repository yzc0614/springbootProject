package com.chinasoft.controller;

import com.chinasoft.mapper.UserMapper;
import com.chinasoft.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/mybatis")
public class MybatisController {

    @Autowired
    private UserMapper userMapper;

    @RequestMapping("/getAll")
    public List<User> getAll(){
        List<User> ulist = userMapper.queryUserList();
        return ulist;
    }
}
