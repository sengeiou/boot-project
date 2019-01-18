package com.xzm.tyb.vo;

import io.swagger.annotations.ApiModelProperty;

//@ApiModel("认证Token")
public class AuthVo {
    @ApiModelProperty(value = "认证access_token",required = true)
    private String access_token;

    public String getAccess_token() {
        return access_token;
    }

    public void setAccess_token(String access_token) {
        this.access_token = access_token;
    }
}
