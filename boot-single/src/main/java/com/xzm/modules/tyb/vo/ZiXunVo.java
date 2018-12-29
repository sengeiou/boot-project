package com.xzm.modules.tyb.vo;

import com.xzm.modules.tyb.pojo.TybZiXun;
import lombok.Data;

import java.util.List;
@Data
public class ZiXunVo {
    public List<TybZiXun> ziXun;
    public void setHandan(List<TybZiXun> ziXun) {
        this.ziXun = ziXun;
    }
}
