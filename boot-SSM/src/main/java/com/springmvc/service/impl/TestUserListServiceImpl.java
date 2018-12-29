package com.springmvc.service.impl;

import com.springmvc.dao.TestUserListMapper;
import com.springmvc.entity.UserList;
import com.springmvc.service.TestUserListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by xuzongmeng on 2017/6/23.
 */

@Service
public class TestUserListServiceImpl implements TestUserListService{
    @Autowired
    private TestUserListMapper testUserListDao;
    @Override
    public int deleteByPrimaryKey(Integer uId) {
        return testUserListDao.deleteByPrimaryKey(uId);
    }

    @Override
    public int insert(UserList record) {
        return testUserListDao.insert(record);
    }

    @Override
    public int insertSelective(UserList record) {
        return testUserListDao.insertSelective(record);
    }

    @Override
    public UserList selectByPrimaryKey(Integer uId) {
        return testUserListDao.selectByPrimaryKey(uId);
    }

    @Override
    public int updateByPrimaryKeySelective(UserList record) {
        return testUserListDao.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(UserList record) {
        return testUserListDao.updateByPrimaryKey(record);
    }
}
