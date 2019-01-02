package com.xzm.single.service;

import com.xzm.common.entity.ServerResponse;
import com.xzm.single.vo.ZiXunVo;

public interface TybZiXunService {
    ServerResponse<ZiXunVo> selectZiXunList(Integer type);
}
