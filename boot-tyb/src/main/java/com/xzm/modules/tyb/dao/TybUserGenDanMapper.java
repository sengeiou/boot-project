package com.xzm.modules.tyb.dao;

import com.xzm.modules.tyb.pojo.TybUserGenDan;

import java.util.List;
//@Mapper
public interface TybUserGenDanMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TybUserGenDan record);

    int insertSelective(TybUserGenDan record);

    TybUserGenDan selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TybUserGenDan record);

    int updateByPrimaryKey(TybUserGenDan record);

    List<TybUserGenDan> selectUserGenDanByUserPhone(String phone);
}