package com.xzm.tyb.dao;


//import com.baomidou.mybatisplus.mapper.BaseMapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xzm.tyb.pojo.entity.TybZiXun;

import java.util.List;

/**
 * 新闻咨询
 */
//@Mapper
//    @Mapper
public interface ZiXunMapper extends BaseMapper<TybZiXun> {
    int deleteByPrimaryKey(Integer id);

    int insertSelective(TybZiXun record);

    TybZiXun selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TybZiXun record);

    int updateByPrimaryKey(TybZiXun record);

    List<TybZiXun> selectZiXunList(Integer type);
}