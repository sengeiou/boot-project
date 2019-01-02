package com.xzm.tyb.dao;


//import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xzm.modules.tyb.pojo.TybUser;
import com.xzm.tyb.pojo.TybUser;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
@Mapper

//@Mapper
public interface TybUserMapper extends BaseMapper<TybUser> {
    int checkUserValid(String phone);

    int deleteByPrimaryKey(Integer id);

//    int insert(TybUser record);

    int insertSelective(TybUser record);

    TybUser selectByPrimaryKey(Integer id);

    TybUser selectByUserNameAndPassWord(@Param("phone") String phone, @Param("password") String password);

    int updateByPrimaryKeySelective(TybUser record);

    int updateByPrimaryKey(TybUser record);

    int updateUserNameByUniqueKey(@Param("phone")String phone,@Param("nick_name")String nick_name);

    TybUser selectByUniqueKey(String phone);
}