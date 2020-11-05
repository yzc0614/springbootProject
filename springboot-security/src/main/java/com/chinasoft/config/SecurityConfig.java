package com.chinasoft.config;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {


        http.authorizeRequests().antMatchers("/").permitAll()
                .antMatchers("/level1/**").hasRole("vip1")
                .antMatchers("/level2/**").hasRole("vip2");

        //未登录跳转登录
        http.formLogin().successForwardUrl("/");
        //关闭防止跨源访问攻击守卫
        http.csrf().disable();
        //注销

        http.rememberMe().rememberMeParameter("remember");
        http.logout().logoutSuccessUrl("/");
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        给密码加密
        auth.inMemoryAuthentication().passwordEncoder(new BCryptPasswordEncoder())
                .withUser("wj").password(new BCryptPasswordEncoder().encode("123")).roles("vip1")
                .and().withUser("wzx").password(new BCryptPasswordEncoder().encode("123")).roles("vip1","vip2");
    }
}
