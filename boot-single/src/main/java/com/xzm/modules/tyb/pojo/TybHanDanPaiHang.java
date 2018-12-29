package com.xzm.modules.tyb.pojo;

import lombok.Data;

import java.util.Date;

@Data
public class TybHanDanPaiHang {

    private Integer id;

    private String title;

    private String producttype;

    private String ordertime;

    private String point;

    private String profit;

    private Date createTime;

    private Date updataTime;

}