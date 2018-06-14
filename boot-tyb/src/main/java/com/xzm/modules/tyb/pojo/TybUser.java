package com.xzm.modules.tyb.pojo;

import lombok.Data;

import java.util.Date;
@Data
public class TybUser {
    private Integer id;

    private String nickName;

    private String phone;

    private String password;

    private String phoneUrl;

    private Integer pushStatus;

    private Date createTime;

    private Date updataTime;


}