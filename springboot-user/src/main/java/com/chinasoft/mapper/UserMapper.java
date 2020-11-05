package com.chinasoft.mapper;

import com.chinasoft.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface UserMapper {

    List<User> getAllUser();

    int addUser(User user);

    int deleteUser(@Param("id") int id);

    int updateUser(User user);
}
