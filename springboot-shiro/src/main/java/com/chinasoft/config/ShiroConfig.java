package com.chinasoft.config;

import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;
import java.util.Map;

@Configuration
public class ShiroConfig {

    @Bean
    public ShiroFilterFactoryBean shiroFilterFactoryBean(@Qualifier("defaultWebSecurityManager") DefaultWebSecurityManager defaultWebSecurityManager){
        ShiroFilterFactoryBean bean = new ShiroFilterFactoryBean();
        bean.setSecurityManager(defaultWebSecurityManager);
        Map<String,String> filtermap = new LinkedHashMap<>();
//        anon: 无需认证访问
//        authc: 必须认证才能访问
//        user: 必须拥有 remember功能才能访问
//        perms: 拥有对某个资源的权限才能访问
//        role: 拥有某个角色权限才能访问
        filtermap.put("/user/*","perms[all]");
//        filtermap.put("/user/*","authc");
        bean.setFilterChainDefinitionMap(filtermap);
        bean.setLoginUrl("/login");
        return bean;
    }

    @Bean
    public DefaultWebSecurityManager defaultWebSecurityManager(@Qualifier("userRealm") UserRealm userRealm){
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        securityManager.setRealm(userRealm);
        return securityManager;
    }

    @Bean
    public UserRealm userRealm(){
        return new UserRealm();
    }
}
