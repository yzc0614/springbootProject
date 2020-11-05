package com.chinasoft.service.impl;

import com.chinasoft.mapper.UserMapper;
import com.chinasoft.pojo.User;
import com.chinasoft.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public List<User> getAllUser() {
        return userMapper.getAllUser();
    }

    @Override
    public int addUser(User user) {

        return userMapper.addUser(user);
    }

    @Override
    public int deleteUser(int id) {

        return userMapper.deleteUser(id);
    }

    @Override
    public int updateUser(User user) {

        return userMapper.updateUser(user);
    }
}
