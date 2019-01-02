//package com.xzm.modules.test.service;
//
//
//import com.xzm.modules.test.jpa.UserJPA;
//import com.xzm.modules.test.pojo.UserEntity;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.cache.annotation.CacheConfig;
//import org.springframework.cache.annotation.Cacheable;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//
///**
// * ========================
// * Created with IntelliJ IDEA.
// * TestUser：恒宇少年
// * Date：2017/4/17
// * Time：22:43
// * 码云：http://git.oschina.net/jnyqy
// * ========================
// */
//@Service
//@CacheConfig(cacheNames = "user")
//public class UserService {
//
//    @Autowired
//    private UserJPA userJPA;
//
//    @Cacheable
//    public List<UserEntity> list()
//    {
//        return userJPA.findAll();
//    }
//}
