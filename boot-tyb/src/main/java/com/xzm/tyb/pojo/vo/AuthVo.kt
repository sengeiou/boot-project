package com.xzm.tyb.pojo.vo

import io.swagger.annotations.ApiModelProperty

//@ApiModel("认证Token")
open class AuthVo {
    //    @ApiModelProperty(value = "认证access_token",required = true)
    //    private String access_token;
    @ApiModelProperty(value = "认证accessToken", required = false)
    var accessToken: String? = null
}
