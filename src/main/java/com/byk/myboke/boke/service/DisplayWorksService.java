package com.byk.myboke.boke.service;

import com.byk.myboke.boke.entity.DisplayWorks;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DisplayWorksService {
    int deleteByPrimaryKey(String id);

    int insert(DisplayWorks record);

    int insertSelective(DisplayWorks record);

    DisplayWorks selectByPrimaryKey(String id);

    List<DisplayWorks> list();

    int updateByPrimaryKeySelective(DisplayWorks record);

    int updateByPrimaryKey(DisplayWorks record);
}