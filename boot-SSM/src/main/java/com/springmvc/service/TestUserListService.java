package com.springmvc.service;

import com.springmvc.entity.UserList;
import org.springframework.stereotype.Service;

/**
 * Created by xuzongmeng on 2017/6/23.
 */

public interface TestUserListService {
    int deleteByPrimaryKey(Integer uId);

    int insert(UserList record);

    int insertSelective(UserList record);

    UserList selectByPrimaryKey(Integer uId);

    int updateByPrimaryKeySelective(UserList record);

    int updateByPrimaryKey(UserList record);
}
