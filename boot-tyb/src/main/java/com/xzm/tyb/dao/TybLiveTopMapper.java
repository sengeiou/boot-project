package com.xzm.tyb.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xzm.tyb.pojo.entity.TybLiveTop;

import java.util.List;
//@Mapper

public interface TybLiveTopMapper extends BaseMapper<TybLiveTop> {
    int deleteByPrimaryKey(Integer id);

//    int insert(TybLiveTop record);

    int insertSelective(TybLiveTop record);

    TybLiveTop selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TybLiveTop record);

    int updateByPrimaryKey(TybLiveTop record);

    List<TybLiveTop> selectLiveTopList();
}