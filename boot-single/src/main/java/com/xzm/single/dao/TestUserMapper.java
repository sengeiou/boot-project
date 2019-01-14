package com.xzm.single.dao;

import com.xzm.single.entity.User;
import com.xzm.single.entity.UserCustom;
import com.xzm.single.entity.UserQueryVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * Created by 10412 on 2016/12/2.
 */
@Mapper
public interface TestUserMapper  //mapper接口，相当于dao接口
{
    //用户信息综合查询
    public List<UserCustom> findUserList(UserQueryVo userQueryVo) ;

    //用户信息综合查询总数
    public int findUserCount(UserQueryVo userQueryVo) ;

    //根据id查询用户信息
    public User findUserById(int id) ;

    //根据用户名查询用户信息
    public List<User> findUserByUsername(String userName) ;


    //根据id查询用户信息，使用 resultMap 输出
    public User findUserByIdResultMap(int id) ;

    //插入用户信息
    public void insetrUser(User user) ;

    //删除用户信息
    public void deleteUserById(int id) ;

    //更新用户信息
    public void updateUserById(User user) ;

}
