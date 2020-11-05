package com.chinasoft.service.impl;

import com.chinasoft.mapper.AdminMapper;
import com.chinasoft.pojo.Admin;
import com.chinasoft.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminMapper adminMapper;

    @Override
    public Admin selectByAccount(String account) {
        return adminMapper.selectByAccount(account);
    }
}
