package com.xzm.tyb.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xzm.tyb.pojo.TybUserGenDan;

import java.util.List;
//@Mapper
//@Mapper

public interface TybUserGenDanMapper extends BaseMapper<TybUserGenDan> {
    int deleteByPrimaryKey(Integer id);

    int insertSelective(TybUserGenDan record);

    TybUserGenDan selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TybUserGenDan record);

    int updateByPrimaryKey(TybUserGenDan record);

    List<TybUserGenDan> selectUserGenDanByUserPhone(String phone);
}