package com.xzm.single.modules.test.dao;
import com.xzm.single.modules.test.po.User;
import com.xzm.single.modules.test.po.UserCustom;
import com.xzm.single.modules.test.po.UserQueryVo;
import java.util.List;

/**
 * Created by 10412 on 2016/12/2.
 */
public interface UserMapper     //mapper接口，相当于dao接口
{
    //用户信息综合查询
    public List<UserCustom> findUserList(UserQueryVo userQueryVo) throws Exception;

    //用户信息综合查询总数
    public int findUserCount(UserQueryVo userQueryVo) throws Exception;

    //根据id查询用户信息
    public User findUserById(int id) throws Exception;

    //根据用户名查询用户信息
    public List<User> findUserByUsername(String userName) throws Exception;


    //根据id查询用户信息，使用 resultMap 输出
    public User findUserByIdResultMap(int id) throws Exception;

    //插入用户信息
    public void insetrUser(User user) throws Exception;

    //删除用户信息
    public void deleteUserById(int id) throws Exception;

    //更新用户信息
    public void updateUserById(User user) throws Exception;

}
