package com.xzm.modules.tyb.dao;

import com.xzm.modules.tyb.pojo.TybImportantMessage;

//@Mapper
public interface TybImportantMessageMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TybImportantMessage record);

    int insertSelective(TybImportantMessage record);

    TybImportantMessage selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TybImportantMessage record);

    int updateByPrimaryKey(TybImportantMessage record);
}