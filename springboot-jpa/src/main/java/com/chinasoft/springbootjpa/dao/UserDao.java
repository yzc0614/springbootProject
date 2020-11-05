package com.chinasoft.springbootjpa.dao;

import com.chinasoft.springbootjpa.pojo.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDao extends JpaRepository<User,Integer> {

    User findByUid(Integer uid);
}
