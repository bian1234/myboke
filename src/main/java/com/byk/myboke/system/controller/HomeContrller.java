package com.byk.myboke.system.controller;

import com.byk.myboke.boke.entity.Visiter;
import com.byk.myboke.boke.service.VisiterService;
import com.byk.myboke.system.commen.IPUtil;
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

    @Autowired
    private IPUtil ipUtil;

    @Autowired
    private VisiterService visiterService;

    @RequestMapping("/")
    public String toIndex(HttpServletRequest request){
        Visiter visiter = new Visiter();
        String ip = ipUtil.getIpAddr(request);
        visiter.setTime(new Date());
        visiter.setVisiterIp(ip);
        visiterService.insertSelective(visiter);
        return "index";
    }
}
