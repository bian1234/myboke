package com.byk.myboke.boke.service;

import com.byk.myboke.boke.entity.Visiter;

public interface VisiterService {
    int deleteByPrimaryKey(String id);

    int insert(Visiter record);

    int insertSelective(Visiter record);

    Visiter selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Visiter record);

    int updateByPrimaryKey(Visiter record);
}