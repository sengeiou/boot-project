package com.springmvc.service.impl;

import com.springmvc.dao.UserListMapper;
import com.springmvc.entity.UserList;
import com.springmvc.service.UserListService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by xuzongmeng on 2017/6/23.
 */
@Service("UserListService")
public class UserListServiceImpl implements UserListService {
    @Resource(name = "UserListDao")
    private UserListMapper userlistDao;

    @Override
    public int deleteByPrimaryKey(Integer uId) {
        return userlistDao.deleteByPrimaryKey(uId);
    }

    @Override
    public int insert(UserList record) {
        return userlistDao.insert(record);
    }

    @Override
    public int insertSelective(UserList record) {
        return userlistDao.insertSelective(record);
    }

    @Override
    public UserList selectByPrimaryKey(Integer uId) {
        return userlistDao.selectByPrimaryKey(uId);
    }

    @Override
    public int updateByPrimaryKeySelective(UserList record) {
        return userlistDao.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(UserList record) {
        return userlistDao.updateByPrimaryKey(record);
    }
}
