package com.springmvc.service;

import com.springmvc.entity.UserList;

/**
 * Created by xuzongmeng on 2017/6/22.
 */
public interface UserListService {
    int deleteByPrimaryKey(Integer uId);

    int insert(UserList record);

    int insertSelective(UserList record);

    UserList selectByPrimaryKey(Integer uId);

    int updateByPrimaryKeySelective(UserList record);

    int updateByPrimaryKey(UserList record);
}
