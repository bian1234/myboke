package com.byk.myboke.boke.mapper;

import com.byk.myboke.boke.entity.Visiter;
import org.springframework.stereotype.Repository;

@Repository
public interface VisiterMapper {
    int deleteByPrimaryKey(String id);

    int insert(Visiter record);

    int insertSelective(Visiter record);

    Visiter selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Visiter record);

    int updateByPrimaryKey(Visiter record);

    int  countIp();
}