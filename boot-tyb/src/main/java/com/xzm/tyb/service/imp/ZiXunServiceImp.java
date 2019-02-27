package com.xzm.tyb.service.imp;
//import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xzm.tyb.common.base.BaseServiceImpl;
import com.xzm.tyb.dao.ZiXunMapper;
import com.xzm.tyb.pojo.entity.TybZiXun;
import com.xzm.tyb.service.ZiXunService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ZiXunServiceImp extends BaseServiceImpl<ZiXunMapper, TybZiXun> implements ZiXunService {

    @Autowired
    private ZiXunMapper ziXunMapper;

    @Override
    public List<TybZiXun> selectZiXunList(Integer type) {
        List<TybZiXun> ziXun = ziXunMapper.selectZiXunList(type);
        return ziXun;
    }
}
