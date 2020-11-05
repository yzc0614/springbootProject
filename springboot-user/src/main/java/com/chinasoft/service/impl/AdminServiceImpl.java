package com.chinasoft.service.impl;

import com.chinasoft.mapper.AdminMapper;
import com.chinasoft.pojo.Admin;
import com.chinasoft.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminMapper adminMapper;

    @Override
    public Admin selectByAccountAndPassword(String account, String password) {
        return adminMapper.selectByAccountAndPassword(account,password);
    }
}
