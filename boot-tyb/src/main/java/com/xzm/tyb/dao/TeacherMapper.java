package com.xzm.tyb.dao;

//import com.xzm.modules.common.dao.Mapper;
//import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
//import org.apache.ibatis.annotations.Mapper;
//import org.apache.ibatis.annotations.Mapper;
import com.xzm.tyb.pojo.entity.TybTeacher;
import org.apache.ibatis.annotations.Param;

import java.util.List;
//@Mapper extends Mapper
//@Mapper

/**
 * extends Mapper<TybTeacher>
 */
public interface TeacherMapper extends BaseMapper<TybTeacher> {
    int deleteByPrimaryKey(Integer id);

//    int insert(TybTeacher record);

    int insertSelective(TybTeacher record);

    TybTeacher selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TybTeacher record);

    int updateByPrimaryKey(TybTeacher record);
    
    int selectTeacherByPrimaryKey(Integer id);

    List<TybTeacher> selectTeacherList();

    /**
     *传递集合必须用 Param注解
     */
    List<TybTeacher> selectTeacherListByIds(@Param("ids") List<Integer> ids);
}