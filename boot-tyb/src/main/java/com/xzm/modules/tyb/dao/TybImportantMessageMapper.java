package com.xzm.modules.tyb.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.xzm.modules.tyb.pojo.TybImportantMessage;

//@Mapper
public interface TybImportantMessageMapper extends BaseMapper<TybImportantMessage> {
    int deleteByPrimaryKey(Integer id);

//    int insert(TybImportantMessage record);

    int insertSelective(TybImportantMessage record);

    TybImportantMessage selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TybImportantMessage record);

    int updateByPrimaryKey(TybImportantMessage record);
}