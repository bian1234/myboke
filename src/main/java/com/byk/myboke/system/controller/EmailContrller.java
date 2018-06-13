package com.byk.myboke.system.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: bianyakun
 * @Date: 2018/6/13 17:45
 * @Todo:
 */
//@RestController
//public class EmailContrller {
//
//    @Autowired
//    JavaMailSender jms;
//
//    @GetMapping("/send")
//    public String send(){
//        //建立邮件消息
//        SimpleMailMessage mainMessage = new SimpleMailMessage();
//        //发送者
//        mainMessage.setFrom("xxxxx@126.com");
//        //接收者
//        mainMessage.setTo("xxxx@qq.com");
//        //发送的标题
//        mainMessage.setSubject("嗨喽");
//        //发送的内容
//        mainMessage.setText("hello world");
//        jms.send(mainMessage);
//        return "1";
//    }
//}
