package com.xzm.tyb.service;

//import com.baomidou.mybatisplus.service.IService;
import com.baomidou.mybatisplus.extension.service.IService;
import com.xzm.tyb.common.base.IBaseService;
import com.xzm.tyb.pojo.entity.TybZiXun;

import java.util.List;


public interface ZiXunService extends IBaseService<TybZiXun> {
    List<TybZiXun> selectZiXunList(Integer type);
}
