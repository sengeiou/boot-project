package com.xzm.tyb.pojo.vo

import io.swagger.annotations.ApiModel
import io.swagger.annotations.ApiModelProperty

@ApiModel("用户昵称修改")
class NiceNameModifyVo {
    @ApiModelProperty(value = "用户电话", required = false)
    var phone: String? = null
    @ApiModelProperty(value = "昵称", required = true)
    var nickName: String? = null
}
