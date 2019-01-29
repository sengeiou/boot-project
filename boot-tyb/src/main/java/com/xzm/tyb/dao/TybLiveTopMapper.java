package com.xzm.tyb.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xzm.tyb.pojo.entity.LiveTop;

import java.util.List;
//@Mapper

public interface TybLiveTopMapper extends BaseMapper<LiveTop> {
    int deleteByPrimaryKey(Integer id);

//    int insert(LiveTop record);

    int insertSelective(LiveTop record);

    LiveTop selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(LiveTop record);

    int updateByPrimaryKey(LiveTop record);

    List<LiveTop> selectLiveTopList();
}