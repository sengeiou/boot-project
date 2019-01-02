package com.xzm.single.dao;

import com.xzm.single.pojo.liveTop;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface TybLiveTopMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(liveTop record);

    int insertSelective(liveTop record);

    liveTop selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(liveTop record);

    int updateByPrimaryKey(liveTop record);

    List<liveTop> selectLiveTopList();
}