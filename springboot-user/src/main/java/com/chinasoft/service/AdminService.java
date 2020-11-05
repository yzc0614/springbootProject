package com.chinasoft.service;

import com.chinasoft.pojo.Admin;

public interface AdminService {

    Admin selectByAccountAndPassword(String account,String password);
}
