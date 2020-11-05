package com.chinasoft.mapper;

import com.chinasoft.pojo.Admin;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface AdminMapper {
    Admin selectByAccountAndPassword(@Param("account") String account,@Param("password") String password);
}
