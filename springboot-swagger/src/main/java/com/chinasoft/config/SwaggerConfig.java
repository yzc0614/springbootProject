package com.chinasoft.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.core.env.Profiles;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    //配置swagger Docket的bean实例
    @Bean
    public Docket docket(Environment environment){
        //获取当前运作环境
        Profiles profiles = Profiles.of("dev");
        boolean flag = environment.acceptsProfiles(profiles);
        System.out.println(flag);
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .groupName("wj")
                //是否开启swagger
                .enable(flag)
                .select()
                //RequestHandlerSelectors 配置扫描接口的方式
                //basePackage 扫描的基本路径
                //any()扫描所有
                .apis(RequestHandlerSelectors.basePackage("com.chinasoft.controller"))
                //ant() 过滤 只能扫描路径/**
                .paths(PathSelectors.ant("/**")).build();
    }

    @Bean
    public Docket docket1(){
        return new Docket(DocumentationType.SWAGGER_2).groupName("A");
    }
    //配置swagger信息
    private ApiInfo apiInfo(){
        Contact contact = new Contact("wj","","913864980@qq.com");
        return new ApiInfo(
                "Hello world",
                "煎和熬都是变美味的方式，加油也是",
                "1.0",
                "urn:tos",
                contact,
                "Apache 2.0",
                "http://www.apache.org/licenses/LICENSE-2.0",
                new ArrayList());
    }
}
