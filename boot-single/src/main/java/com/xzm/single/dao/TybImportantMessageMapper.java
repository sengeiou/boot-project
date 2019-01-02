package com.xzm.single.dao;

import com.xzm.single.pojo.TybImportantMessage;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TybImportantMessageMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TybImportantMessage record);

    int insertSelective(TybImportantMessage record);

    TybImportantMessage selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TybImportantMessage record);

    int updateByPrimaryKey(TybImportantMessage record);
}