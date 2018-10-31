package com.byk.myboke.boke.controller;

import com.byk.myboke.boke.entity.DisplayWorks;
import com.byk.myboke.boke.service.DisplayWorksService;
import com.byk.myboke.commen.util.RestUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author: bianyakun
 * @Date: 2018/6/29 13:02
 * @Todo:
 */
@RestController
@RequestMapping("/displayWork")
public class DisplayWorkController {


    @Autowired
    private DisplayWorksService displayWorksService;

    @Value("${byk.pagePath}")
    private String pagePath;

    @PostMapping("/insert")
    public RestUtil insertSelective(DisplayWorks displayWorks){
        RestUtil restUtil = new RestUtil();
        displayWorks.setPageAddress(pagePath);
        int result = displayWorksService.insertSelective(displayWorks);
        if (result < 1){
            restUtil.setMsg("插入失败");
            restUtil.setStatus(20002);
            return  restUtil;
        }else {
            restUtil.setMsg("插入成功");
            restUtil.setStatus(20000);
            return  restUtil;
        }
    }

    @GetMapping("/list")
    public RestUtil list(){
        RestUtil restUtil = new RestUtil();
        List<DisplayWorks> displayWorks = displayWorksService.list();
        for (DisplayWorks works:displayWorks) {
            works.setPageAddress(pagePath);
        }
        if (displayWorks.isEmpty()){
            restUtil.setMsg("数据为空");
            restUtil.setStatus(20002);
            return  restUtil;
        }else {
            restUtil.setMsg("查询成功");
            restUtil.setStatus(20000);
            restUtil.setData(displayWorks);
            for (DisplayWorks works2:displayWorks) {
                System.out.println(works2);
            }
            return  restUtil;
        }
    }
}
