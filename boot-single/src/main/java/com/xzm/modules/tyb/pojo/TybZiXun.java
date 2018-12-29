package com.xzm.modules.tyb.pojo;

import lombok.Data;

import java.util.Date;
@Data
public class TybZiXun {
    private Integer id;

    private Integer type;

    private String title;

    private String description;

    private String url;

    private Date createTime;

    private Date updataTime;

}