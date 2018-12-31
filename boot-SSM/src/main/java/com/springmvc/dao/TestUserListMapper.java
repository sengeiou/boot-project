package com.springmvc.dao;
import com.springmvc.entity.UserList;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface TestUserListMapper {
    int deleteByPrimaryKey(Integer uId);

    int insert(UserList record);

    int insertSelective(UserList record);

    UserList selectByPrimaryKey(@Param("uId") Integer uId);

    int updateByPrimaryKeySelective(UserList record);

    int updateByPrimaryKey(UserList record);
}