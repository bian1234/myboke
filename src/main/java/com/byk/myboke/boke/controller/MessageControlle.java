package com.byk.myboke.boke.controller;

import com.byk.myboke.boke.entity.BokeMessage;
import com.byk.myboke.boke.service.MessageService;
import com.byk.myboke.commen.IPUtil;
import com.byk.myboke.commen.MailUtil;
import com.byk.myboke.commen.RestUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @Author: bianyakun
 * @Date: 2018/6/13 14:47
 * @Todo:
 */
@RestController
@RequestMapping("/message")
public class MessageControlle {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private MessageService messageService;

    @Autowired
    private MailUtil mailUtil;


//    @Autowired
//    private IPUtil ipUtil;


    @PostMapping("/insert")
    public RestUtil insert(HttpServletRequest request, BokeMessage bokeMessage) throws Exception{
        RestUtil restUtil = new RestUtil();
        String ip = IPUtil.getIpAddr(request);
        bokeMessage.setUserIp(ip);
        //先发送邮件再操作数据库
        try {
            mailUtil.sendEmailToVistor(bokeMessage);
        }catch (Exception e){
            logger.info("邮箱地址错误");
            bokeMessage.setReply(1);
        }
        if (messageService.insertSelective(bokeMessage) > 0) {
            restUtil.setMsg("我会尽快回复您的留言");
            restUtil.setStatus(20000);
            mailUtil.sendEmailToMe(bokeMessage,ip);
            logger.info("Ip为"+ip+"的用户留言了");
        } else {
            restUtil.setMsg("未知错误，请联系中边");
            restUtil.setStatus(20001);
            restUtil.setData(bokeMessage);
        }
        return restUtil;
    }
}
