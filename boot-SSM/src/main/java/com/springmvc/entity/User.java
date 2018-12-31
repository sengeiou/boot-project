package com.springmvc.entity;

import lombok.*;

import java.io.Serializable;

/**
 * Created by Vitelon on 2017-03-30
 * 用户实体类.
 */

public class User implements Serializable {


    public User(String id, String username, String password, String sex) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.sex = sex;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    private static final long serialVersionUID = 1L;

    /**
     * 用户ID
     */

    private String id;
    /**
     * 用户名
     */

    private String username;
    /**
     * 密码
     */

    private String password;
    /**
     * 姓名
     */

    private String sex;




}
