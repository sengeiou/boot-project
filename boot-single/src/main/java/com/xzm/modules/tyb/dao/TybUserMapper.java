package com.xzm.modules.tyb.dao;


import com.xzm.modules.tyb.pojo.TybUser;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface TybUserMapper {
    int checkUserValid(String phone);

    int deleteByPrimaryKey(Integer id);

    int insert(TybUser record);

    int insertSelective(TybUser record);

    TybUser selectByPrimaryKey(Integer id);

    TybUser selectByUserNameAndPassWord(@Param("phone") String phone, @Param("password") String password);

    int updateByPrimaryKeySelective(TybUser record);

    int updateByPrimaryKey(TybUser record);

    int updateUserNameByUniqueKey(@Param("phone")String phone,@Param("nick_name")String nick_name);

    TybUser selectByUniqueKey(String phone);
}