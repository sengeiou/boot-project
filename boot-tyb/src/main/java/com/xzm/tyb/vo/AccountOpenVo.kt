package com.xzm.tyb.vo

import io.swagger.annotations.ApiModel
import io.swagger.annotations.ApiModelProperty

@ApiModel("开户")
class AccountOpenVo {
    @ApiModelProperty(value = "用户电话", required = false)
    var phone: Long? = null
    @ApiModelProperty(value = "身份证姓名", required = true)
    var userName: String? = null
    @ApiModelProperty(value = "身份证号", required = true)
    var idCard: Long? = null
    @ApiModelProperty(value = "交易所平台code", required = true)
    var platformCode: String? = null
}
