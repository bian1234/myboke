package com.byk.myboke.boke.service.impl;

import com.byk.myboke.boke.entity.Message;
import com.byk.myboke.boke.mapper.MessageMapper;
import com.byk.myboke.boke.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author: bianyakun
 * @Date: 2018/6/13 14:43
 * @Todo:
 */
@Service
public class MessageServiceImpl implements MessageService{

    @Autowired
    private MessageMapper messageMapper;

    @Override
    public int deleteByPrimaryKey(String id) {
        return 0;
    }

    @Override
    public int insert(Message record) {

        return 0;
    }

    @Override
    public int insertSelective(Message record) {

        return messageMapper.insertSelective(record);
    }

    @Override
    public Message selectByPrimaryKey(String id) {
        return null;
    }

    @Override
    public int updateByPrimaryKeySelective(Message record) {
        return 0;
    }

    @Override
    public int updateByPrimaryKey(Message record) {
        return 0;
    }
}
