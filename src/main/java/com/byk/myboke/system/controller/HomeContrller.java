package com.byk.myboke.system.controller;

import com.byk.myboke.boke.entity.Visiter;
import com.byk.myboke.boke.service.VisiterService;
import com.byk.myboke.commen.IPUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

/**
 * @Author: bianyakun
 * @Date: 2018/6/13 10:14
 * @Todo:   页面跳转
 */
@Controller
public class HomeContrller {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

//    @Autowired
//    private IPUtil 什么;

    @Autowired
    private VisiterService visiterService;

    @RequestMapping("/")
    public String toIndex(HttpServletRequest request){

        Visiter visiter = new Visiter();
        String ip = IPUtil.getIpAddr(request);
        logger.info(ip+"访问了网页");
        visiter.setTime(new Date());
        visiter.setVisiterIp(ip);
        visiterService.insertSelective(visiter);
        return "index";
    }
}
