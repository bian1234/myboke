package com.byk.myboke.system.commen;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * @Author: bianyakun
 * @Date: 2018/6/15 16:09
 * @Todo:
 */
@Component

public class SchedulerTask {



    private int count=0;



    //@Scheduled(cron="*/1 * * * * ?")     //每隔1秒打印一句话
    private void process(){

        System.out.println("this is scheduler task runing  "+(count++));

    }

}