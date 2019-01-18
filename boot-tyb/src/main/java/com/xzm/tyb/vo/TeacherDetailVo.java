package com.xzm.tyb.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.web.bind.annotation.RequestParam;

@ApiModel("老师详情")
public class TeacherDetailVo extends  PageVo{
    @ApiModelProperty(value = "老师teacherId",required = true)
    public   Integer teacherId;
    @ApiModelProperty(value="老师phone",required = true)
    public String phone;

    public Integer getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(Integer teacherId) {
        this.teacherId = teacherId;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
