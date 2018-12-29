package com.xzm.modules.tyb.dao;


import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.xzm.modules.tyb.pojo.TybZiXun;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 新闻咨询
 */
@Mapper
public interface TybZiXunMapper extends BaseMapper<TybZiXun> {
    int deleteByPrimaryKey(Integer id);

//    int insert(TybZiXun record);

    int insertSelective(TybZiXun record);

    TybZiXun selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TybZiXun record);

    int updateByPrimaryKey(TybZiXun record);

    List<TybZiXun> selectZiXunList(Integer type);
}