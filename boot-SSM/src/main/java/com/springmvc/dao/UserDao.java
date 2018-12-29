package com.springmvc.dao;

import com.springmvc.entity.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Vitelon on 2017-03-30
 * 用户dao接口.
 */
//@Repository("UserDao")  不要这个属性也可以
public interface UserDao {

    /**
     * 	Created by Vitelon on 2017-03-22
     * 	根据用户名和密码查询用户
     * @param username
     * @param password
     * @return
     * * Mybatis 多个参数需要用到 Param注解
     */


    public User findByUsernameAndPwd(@Param("username") String username, @Param("password") String password);

    /**
     * 	Created by Vitelon on 2017-03-30
     * 	获取用户
     * @return
     */
    public List<User> find(User User);

    /**
     * 	Created by Vitelon on 2017-03-30
     * 	新增
     * @param User
     */
    public void add(User User);

    /**
     * 	Created by Vitelon on 2017-03-30
     * 	修改
     * @param User
     */
    public void update(User User);

    /**
     * 	Created by Vitelon on 2017-03-30
     * 	删除
     * @param id
     */
    public void delete(String id);
}