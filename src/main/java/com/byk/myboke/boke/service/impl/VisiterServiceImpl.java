package com.byk.myboke.boke.service.impl;

import com.byk.myboke.boke.entity.Visiter;
import com.byk.myboke.boke.mapper.VisiterMapper;
import com.byk.myboke.boke.service.VisiterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author: bianyakun
 * @Date: 2018/6/15 9:12
 * @Todo:
 */
@Service
public class VisiterServiceImpl  implements VisiterService {

    @Autowired
    private VisiterMapper visiterMapper;
    @Override
    public int deleteByPrimaryKey(String id) {
        return 0;
    }

    @Override
    public int insert(Visiter record) {
        return 0;
    }

    @Override
    public int insertSelective(Visiter record) {
        return visiterMapper.insertSelective(record);
    }

    @Override
    public int countIp() {
        return 0;
    }

    @Override
    public Visiter selectByPrimaryKey(String id) {
        return null;
    }

    @Override
    public int updateByPrimaryKeySelective(Visiter record) {
        return 0;
    }

    @Override
    public int updateByPrimaryKey(Visiter record) {
        return 0;
    }
}
