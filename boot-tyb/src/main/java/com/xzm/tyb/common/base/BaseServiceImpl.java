package com.xzm.tyb.common.base;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xzm.tyb.service.imp.TybUserServiceImp;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public abstract class BaseServiceImpl<M extends BaseMapper<T>, T> implements IBaseService<T> {
    public Log logger = LogFactory.getLog(getClass());
}
