package com.xzm.tyb.service.imp;
//import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.xzm.tyb.common.entity.ServerResponse;
import com.xzm.tyb.dao.TybZiXunMapper;
import com.xzm.tyb.pojo.TybZiXun;
import com.xzm.tyb.service.TybZiXunService;
import com.xzm.tyb.vo.ZiXunVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
public class TybZiXunServiceImp extends ServiceImpl<TybZiXunMapper, TybZiXun> implements TybZiXunService {

    @Autowired
    private TybZiXunMapper ziXunMapper;

    @Override
    public ServerResponse selectZiXunList(Integer type) {
        List<TybZiXun> ziXun = ziXunMapper.selectZiXunList(type);
        ZiXunVo ziXunVo = new ZiXunVo();
        ziXunVo.setHandan(ziXun);
        return ServerResponse.createBySuccess(ziXunVo);
    }
}
