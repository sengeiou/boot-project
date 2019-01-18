package com.xzm.tyb.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xzm.tyb.common.entity.ServerResponse;
import com.xzm.tyb.pojo.TybZiXun;
import com.xzm.tyb.service.TybZiXunService;
import com.xzm.tyb.utils.Resp;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Api(tags = "测试")
@RestController
@RequestMapping(value = "/test")
public class TestController  extends BaseController{
    @Autowired
    private TybZiXunService ziXunService;

    /**
     * 获取咨询新闻列表
     */
    @GetMapping("/test1")
    public Resp test1(@RequestParam(defaultValue = "1") int pageNum, @RequestParam(defaultValue = "5") int pageSize) {

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

}
