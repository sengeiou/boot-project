package com.xzm.single.service.imp;

import com.xzm.common.entity.ServerResponse;
import com.xzm.single.dao.TybZiXunMapper;
import com.xzm.single.pojo.TybZiXun;
import com.xzm.single.service.TybZiXunService;
import com.xzm.single.vo.ZiXunVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TybZiXunServiceImp implements TybZiXunService {

    @Autowired
    private TybZiXunMapper ziXunMapper;

    @Override
    public ServerResponse selectZiXunList(Integer type) {
        List<TybZiXun> ziXun = ziXunMapper.selectZiXunList(type);
        ZiXunVo ziXunVo = new ZiXunVo();
        ziXunVo.setHandan(ziXun);
        return ServerResponse.createBySuccess("新闻咨询获取成功", ziXunVo);
    }
}
