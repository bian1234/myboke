package com.byk.myboke.boke.service;

import com.byk.myboke.boke.entity.Message;

/**
 * @Author: bianyakun
 * @Date: 2018/6/13 14:43
 * @Todo:
 */

public interface MessageService {

    int deleteByPrimaryKey(String id);

    int insert(Message record);

    int insertSelective(Message record);

    Message selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Message record);

    int updateByPrimaryKey(Message record);
}


