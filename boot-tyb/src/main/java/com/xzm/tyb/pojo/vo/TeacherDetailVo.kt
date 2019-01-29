package com.xzm.tyb.pojo.vo

import io.swagger.annotations.ApiModel
import io.swagger.annotations.ApiModelProperty

@ApiModel("老师详情")
class TeacherDetailVo {
    //    @ApiModelProperty(value="老师phone",required = true)
    //    private String phone;

    @ApiModelProperty(value = "老师teacherId", required = true)
    var teacherId: Int? = null


}
