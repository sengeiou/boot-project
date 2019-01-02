package com.xzm.tyb.service;

import com.xzm.common.entity.ServerResponse;
import com.xzm.modules.tyb.vo.ZiXunVo;

public interface TybZiXunService {
    ServerResponse<ZiXunVo> selectZiXunList(Integer type);
}
