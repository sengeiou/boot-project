package com.xzm.tyb.vo

import io.swagger.annotations.ApiModel
import io.swagger.annotations.ApiModelProperty

@ApiModel("新闻列表")
class NewsListVo : PageVo(){
    @ApiModelProperty(value = "新闻类型", required = true)
    var type: Int? = 1

}
