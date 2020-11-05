package com.chinasoft.mapper;

import com.chinasoft.pojo.Admin;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface AdminMapper {
    Admin selectByAccount(String account);
}
