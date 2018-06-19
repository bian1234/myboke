package com.byk.myboke.boke.service;

import com.byk.myboke.boke.entity.Visiter;

public interface VisiterService {
    int deleteByPrimaryKey(String id);

    int insert(Visiter record);

    int insertSelective(Visiter record);

    Visiter selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Visiter record);

    int updateByPrimaryKey(Visiter record);

    /**
     * @Author: bianyakun
     * @Date: 2018/6/15 16:17
     * @todo: 统计昨天的访问量
     * @param:   * @param null
     */
    int  countIp();
}