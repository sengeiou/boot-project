package com.xzm.modules.tyb.dao;

import com.xzm.tyb.pojo.TybTeacher;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
@Mapper
public interface TybTeacherMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TybTeacher record);

    int insertSelective(TybTeacher record);

    TybTeacher selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TybTeacher record);

    int updateByPrimaryKey(TybTeacher record);

    List<TybTeacher> selectTeacherList();

    /**
     *传递集合必须用 Param注解
     */
    List<TybTeacher> selectTeacherListByIds(@Param("ids") List<Integer> ids);
}