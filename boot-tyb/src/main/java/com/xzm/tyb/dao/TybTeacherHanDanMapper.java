package com.xzm.tyb.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xzm.tyb.pojo.TybTeacherHanDan;
import org.apache.ibatis.annotations.Param;

import java.util.List;
//@Mapper

//@Mapper
public interface TybTeacherHanDanMapper extends BaseMapper<TybTeacherHanDan> {
    int deleteByPrimaryKey(Integer id);

    int insertSelective(TybTeacherHanDan record);

    TybTeacherHanDan selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TybTeacherHanDan record);

    int updateByPrimaryKey(TybTeacherHanDan record);

    List<TybTeacherHanDan> selectGenDanTeacherListByTeacherIds(@Param("ids") List<Integer> ids);
}