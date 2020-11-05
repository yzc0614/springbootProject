package com.chinasoft.config;

import com.chinasoft.interceptor.LoginInterceper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MyMvcConfig implements WebMvcConfigurer {

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/index.html").setViewName("index");
    }

    //    国际化注入容器
    @Bean
    public LocaleResolver localeResolver(){
        return new MyLocalResolver();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginInterceper()).addPathPatterns("/**").excludePathPatterns("/user/login","/user/","/static/*");
    }
}
