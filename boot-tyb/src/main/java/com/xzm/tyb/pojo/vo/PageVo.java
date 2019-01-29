package com.xzm.tyb.pojo.vo;
import io.swagger.annotations.ApiModelProperty;

public class PageVo extends AuthVo {
    @ApiModelProperty(value = "分页pageNum")
    private   int pageNum = 1;
    @ApiModelProperty("分页pageSize")
    private int pageSize = 5;

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }
}
