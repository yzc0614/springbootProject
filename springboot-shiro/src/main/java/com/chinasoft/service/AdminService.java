package com.chinasoft.service;

import com.chinasoft.pojo.Admin;

public interface AdminService {
    Admin selectByAccount(String account);
}
