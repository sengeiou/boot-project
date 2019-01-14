package com.xzm.tyb.dao;

import com.xzm.tyb.pojo.liveTop;

import java.util.List;
//@Mapper

public interface TybLiveTopMapper {
    int deleteByPrimaryKey(Integer id);

//    int insert(liveTop record);

    int insertSelective(liveTop record);

    liveTop selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(liveTop record);

    int updateByPrimaryKey(liveTop record);

    List<liveTop> selectLiveTopList();
}