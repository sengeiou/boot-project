package com.xzm.tyb.pojo.vo

import io.swagger.annotations.ApiModel
import io.swagger.annotations.ApiModelProperty

@ApiModel("用户")
class UserVo {
    @ApiModelProperty(value = "手机号", required = true)
    var phone: String? = null
}
