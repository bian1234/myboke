package com.byk.myboke.boke.service.impl;

import com.byk.myboke.boke.entity.BokeMessage;
import com.byk.myboke.boke.mapper.BokeMessageMapper;
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
    private BokeMessageMapper messageMapper;

    @Override
    public int deleteByPrimaryKey(String id) {
        return 0;
    }

    @Override
    public int insert(BokeMessage record) {
        return 0;
    }

    @Override
    public int insertSelective(BokeMessage record) {

        return messageMapper.insertSelective(record);
    }

    @Override
    public BokeMessage selectByPrimaryKey(String id) {
        return null;
    }

    @Override
    public int updateByPrimaryKeySelective(BokeMessage record) {
        return 0;
    }

    @Override
    public int updateByPrimaryKey(BokeMessage record) {
        return 0;
    }
}
