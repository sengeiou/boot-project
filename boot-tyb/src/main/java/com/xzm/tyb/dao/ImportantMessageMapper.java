package com.xzm.tyb.dao;

//import com.baomidou.mybatisplus.mapper.BaseMapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xzm.tyb.pojo.entity.TybImportantMessage;

//@Mapper
public interface ImportantMessageMapper extends BaseMapper<TybImportantMessage> {
    int deleteByPrimaryKey(Integer id);

    int insertSelective(TybImportantMessage record);

    TybImportantMessage selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TybImportantMessage record);

    int updateByPrimaryKey(TybImportantMessage record);
}