package com.chinasoft.service;

import com.chinasoft.pojo.User;

import java.util.List;

public interface UserService {

    List<User> getAllUser();

    int addUser(User user);

    int deleteUser(int id);

    int updateUser(User user);
}
