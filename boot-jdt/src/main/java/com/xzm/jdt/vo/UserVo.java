package com.xzm.jdt.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.NotBlank;

@ApiModel(value = "用户参数")
public class UserVo {
    @ApiModelProperty(value = "userId")
    @NotBlank(message="用户名不能为空")
    private Integer userId;
    @ApiModelProperty(value = "用户名")
    @NotBlank(message="用户名不能为空")
    private String userName;


    public UserVo() {
    }

    public UserVo(Integer userId, String userName) {
        this.userId = userId;
        this.userName = userName;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
