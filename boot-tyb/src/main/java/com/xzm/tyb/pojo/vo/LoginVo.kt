package com.xzm.tyb.pojo.vo

import io.swagger.annotations.ApiModel
import io.swagger.annotations.ApiModelProperty

@ApiModel("登录")
class LoginVo {
    @ApiModelProperty(value = "手机号", required = true)
    var phone: String? = null
    @ApiModelProperty(value = "密码", required = true)
    var password: String? = null

}
