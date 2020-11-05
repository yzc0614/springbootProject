package com.chinasoft.service;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class ScheduleService {

    @Scheduled(cron = "0 39 12 * * 0-7")
    public void schedule(){
        System.out.println("定时任务");
    }
}
