package com.chinasoft.config;


import com.chinasoft.pojo.Admin;
import com.chinasoft.service.AdminService;

import org.springframework.beans.factory.annotation.Autowired;

public class UserRealm extends Au{

    @Autowired
    private AdminService adminService;


//    @Override
//    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
//        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
//        Subject subject = SecurityUtils.getSubject();
//        Admin admin = (Admin) subject.getPrincipal();
//        if(admin.getPermission()==1){
//            info.addStringPermission("all");
//        }
//        return info;
//    }
//
//    @Override
//    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
//        UsernamePasswordToken usertoken = (UsernamePasswordToken) token;
//        Admin admin = adminService.selectByAccount(usertoken.getUsername());
//        if(admin==null){
//            return null;
//        }
//        return new SimpleAuthenticationInfo(admin,admin,"");
//    }
}
