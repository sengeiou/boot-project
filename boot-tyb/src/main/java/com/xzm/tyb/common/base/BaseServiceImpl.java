package com.xzm.tyb.common.base;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class BaseServiceImpl<M extends BaseMapper<T>, T> extends ServiceImpl<M, T> implements IBaseService<T> {
    public Log logger = LogFactory.getLog(getClass());

////    @Override
////    public IPage<T> page(IPage<T> page) {
////        return null;
////    }
//
//    @Override
//    public IPage<T> page(IPage<T> page, Wrapper<T> queryWrapper) {
//        return super.page(page, queryWrapper);
//    }
}
