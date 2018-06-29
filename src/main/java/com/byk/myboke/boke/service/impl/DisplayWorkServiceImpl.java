package com.byk.myboke.boke.service.impl;

import com.byk.myboke.boke.entity.DisplayWorks;
import com.byk.myboke.boke.mapper.DisplayWorksMapper;
import com.byk.myboke.boke.service.DisplayWorksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: bianyakun
 * @Date: 2018/6/29 13:00
 * @Todo:
 */
@Service
public class DisplayWorkServiceImpl  implements DisplayWorksService {


    @Autowired
    private DisplayWorksMapper displayWorksMapper;

    @Override
    public int deleteByPrimaryKey(String id) {
        return 0;
    }

    @Override
    public int insert(DisplayWorks record) {
        return 0;
    }

    @Override
    public List<DisplayWorks> list() {
        return displayWorksMapper.list();
    }

    @Override
    public int insertSelective(DisplayWorks record) {
        return displayWorksMapper.insertSelective(record);
    }

    @Override
    public DisplayWorks selectByPrimaryKey(String id) {
        return null;
    }

    @Override
    public int updateByPrimaryKeySelective(DisplayWorks record) {
        return 0;
    }

    @Override
    public int updateByPrimaryKey(DisplayWorks record) {
        return 0;
    }
}
