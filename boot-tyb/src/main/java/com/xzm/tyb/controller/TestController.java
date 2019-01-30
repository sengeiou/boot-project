package com.xzm.tyb.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xzm.tyb.common.base.BaseController;
import com.xzm.tyb.common.entity.ServerResponse;
import com.xzm.tyb.pojo.entity.TybUser;
import com.xzm.tyb.pojo.entity.TybZiXun;
import com.xzm.tyb.pojo.vo.PageVo;
import com.xzm.tyb.service.TybZiXunService;
import com.xzm.tyb.utils.Resp;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags = "测试")
@RestController
@RequestMapping(value = "/test")
public class TestController  extends BaseController {
    @Autowired
    private TybZiXunService ziXunService;

    /**
     * 获取咨询新闻列表
     */
    @GetMapping("/test1")
    public Resp test1(@RequestParam(defaultValue = "1") int pageNum,
                      @RequestParam(defaultValue = "10") int pageSize) {

        logger.debug("=pageNum==" + pageNum);
        logger.debug("=pageSize==" + pageSize);
        List<TybZiXun> list = ziXunService.list();
        return Resp.success(list, 5l, 1, 3);
//      return Resp.s(ziXunService.page(page));

    }
    /**
     * 获取咨询新闻列表
     */
    @GetMapping("/test2")
    public Resp test2() {
//        List<TybZiXun> list = ziXunService.list();
        String str= null;
        System.out.println(str.length());
        return Resp.success(Resp.success("哈哈哈"));
    }

    /**
     * 获取咨询新闻列表
     */
    @PostMapping("/test3")
    public ServerResponse test3(@RequestBody PageVo vo) {
//        List<TybZiXun> list = ziXunService.list();
        Page<TybZiXun> page = new Page<>(vo.getPageNum(),vo.getPageSize());
//        QueryWrapper<TybZiXun> diseaseQueryWrapperw = new QueryWrapper<>();
//        UpdateWrapper<TybZiXun> updateWrapper = new UpdateWrapper<>();
////        updateWrapper.
//        IPage<TybZiXun> page1 = diseaseQueryWrapperw.select(page, diseaseQueryWrapperw);


//        TybUser tybUser = userMapper.selectOne(new QueryWrapper<TybUser>()
//                .lambda().eq(TybUser::getPhone,phone));
//        Integer type = new TybZiXun().getType();
//        LambdaQueryWrapper<TybZiXun> queryWrapper = new QueryWrapper<>().lambda().eq(TybZiXun::getType, 1);

        IPage<TybZiXun> page1 = ziXunService.page(page,new QueryWrapper<TybZiXun>()
                .lambda().eq(TybZiXun::getType, 1));
        return ServerResponse.createBySuccess(page1);
    }
}
