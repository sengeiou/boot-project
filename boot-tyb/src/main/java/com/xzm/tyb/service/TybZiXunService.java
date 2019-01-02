package com.xzm.tyb.service;

//import com.baomidou.mybatisplus.service.IService;
import com.baomidou.mybatisplus.extension.service.IService;
import com.xzm.tyb.common.entity.ServerResponse;
import com.xzm.tyb.pojo.TybZiXun;
import com.xzm.tyb.vo.ZiXunVo;


public interface TybZiXunService extends IService<TybZiXun> {
    ServerResponse<ZiXunVo> selectZiXunList(Integer type);
}
