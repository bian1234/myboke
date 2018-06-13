package com.byk.myboke.boke.controller;

import com.byk.myboke.boke.entity.Message;
import com.byk.myboke.boke.service.MessageService;
import com.byk.myboke.system.commen.IPUtil;
import com.byk.myboke.system.commen.MailUtil;
import com.byk.myboke.system.commen.RestUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;

/**
 * @Author: bianyakun
 * @Date: 2018/6/13 14:47
 * @Todo:
 */
@RestController
@RequestMapping("/message")
public class MessageControlle {




    @Autowired
    private MessageService messageService;


    @PostMapping("/insert")
    public RestUtil insert(HttpServletRequest request,Message message){
        RestUtil restUtil = new RestUtil();
        String IP = IPUtil.getIpAddr(request);
        message.setUserIp(IP);
        if ( messageService.insertSelective(message) > 0){
            restUtil.setMsg("我会尽快回复您的留言");
            restUtil.setStatus(20000);
            //MailUtil.
        }else {
            restUtil.setMsg("未知错误，请联系中边");
            restUtil.setStatus(20001);
            restUtil.setData(message);
        }
       return restUtil;
    }
}
