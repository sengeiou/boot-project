package com.xzm.tyb.pojo.vo

import io.swagger.annotations.ApiModelProperty

open class PageVo : AuthVo() {
    @ApiModelProperty(value = "分页pageNum")
    var pageNum = 1
    @ApiModelProperty("分页pageSize")
    var pageSize = 10
}
