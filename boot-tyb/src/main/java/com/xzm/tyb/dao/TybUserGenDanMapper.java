package com.xzm.tyb.dao;

import com.xzm.modules.tyb.pojo.TybUserGenDan;
import com.xzm.tyb.pojo.TybUserGenDan;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
//@Mapper
@Mapper

public interface TybUserGenDanMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TybUserGenDan record);

    int insertSelective(TybUserGenDan record);

    TybUserGenDan selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TybUserGenDan record);

    int updateByPrimaryKey(TybUserGenDan record);

    List<TybUserGenDan> selectUserGenDanByUserPhone(String phone);
}