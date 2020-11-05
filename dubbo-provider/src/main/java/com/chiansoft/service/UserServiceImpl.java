package com.chiansoft.service;

import org.apache.dubbo.config.annotation.Service;
import org.springframework.stereotype.Component;

@Service
@Component
public class UserServiceImpl implements UserService {

    @Override
    public void hello() {
        System.out.println("hello world");
    }
}
