package com.xzm.tyb.vo

import io.swagger.annotations.ApiModel
import io.swagger.annotations.ApiModelProperty

@ApiModel("老师列表")
class TeacherListVo : PageVo(){
    @ApiModelProperty(value = "电话", required = true)
    var phone: String? = null

}
