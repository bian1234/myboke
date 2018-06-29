package com.byk.myboke.boke.mapper;

import com.byk.myboke.boke.entity.BokeMessage;
import org.springframework.stereotype.Repository;

@Repository
public interface BokeMessageMapper {
    int deleteByPrimaryKey(String id);

    int insert(BokeMessage record);

    int insertSelective(BokeMessage record);

    BokeMessage selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(BokeMessage record);

    int updateByPrimaryKey(BokeMessage record);
}