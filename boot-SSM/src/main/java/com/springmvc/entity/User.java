package com.springmvc.entity;

import lombok.*;

import java.io.Serializable;

/**
 * Created by Vitelon on 2017-03-30
 * 用户实体类.
 */
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 用户ID
     */
    @Getter
    @Setter
    private String id;
    /**
     * 用户名
     */
    @Getter
    @Setter
    private String username;
    /**
     * 密码
     */
    @Getter
    @Setter
    private String password;
    /**
     * 姓名
     */
    @Getter
    @Setter
    private String sex;




}
