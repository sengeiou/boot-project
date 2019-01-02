package com.xzm.tyb.service;

//import com.baomidou.mybatisplus.service.IService;
import com.baomidou.mybatisplus.extension.service.IService;
import com.xzm.common.entity.ServerResponse;
import com.xzm.modules.tyb.pojo.TybZiXun;
import com.xzm.modules.tyb.vo.ZiXunVo;

public interface TybZiXunService extends IService<TybZiXun> {
    ServerResponse<ZiXunVo> selectZiXunList(Integer type);
}
