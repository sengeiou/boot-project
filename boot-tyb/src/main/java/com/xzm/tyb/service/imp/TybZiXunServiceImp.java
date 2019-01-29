package com.xzm.tyb.service.imp;
//import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xzm.tyb.dao.TybZiXunMapper;
import com.xzm.tyb.pojo.entity.TybZiXun;
import com.xzm.tyb.service.TybZiXunService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class TybZiXunServiceImp extends ServiceImpl<TybZiXunMapper, TybZiXun> implements TybZiXunService {

    @Autowired
    private TybZiXunMapper ziXunMapper;

    @Override
    public List<TybZiXun> selectZiXunList(Integer type) {
        List<TybZiXun> ziXun = ziXunMapper.selectZiXunList(type);
        return ziXun;
    }
}
