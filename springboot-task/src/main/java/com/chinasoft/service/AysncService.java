package com.chinasoft.service;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;


@Service
public class AysncService {

    @Async
    public void testAsync() throws InterruptedException {
        //设置三秒后执行
        Thread.sleep(3000);
        System.out.println("异步任务");
    }
}
