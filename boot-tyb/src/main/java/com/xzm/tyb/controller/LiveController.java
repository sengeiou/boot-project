package com.xzm.tyb.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xzm.tyb.common.entity.ServerResponse;
import com.xzm.tyb.pojo.entity.TybZiXun;
import com.xzm.tyb.service.TybLiveService;
import com.xzm.tyb.service.TybZiXunService;
import com.xzm.tyb.pojo.vo.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Api(tags = "直播")
@RestController
@RequestMapping(value = "/live")
public class LiveController extends BaseController {
    //
    @Autowired
    private TybLiveService liveService;
    @Autowired
    private TybZiXunService ziXunService;
//    @Autowired
//    private TybUserGenDanMapper userGenDanMapper;

    @ApiOperation("首页直播室banner")
    @PostMapping("/banner")
    public ServerResponse banner() {
        return ServerResponse.createBySuccess(liveService.selectLiveTopList());
    }

    @ApiOperation("获取重要消息")
    @PostMapping("/banner/message")
    public ServerResponse bannerMessage(@RequestBody BannerMessageVo vo) {
        return ServerResponse.createBySuccess(liveService.selectImportantMessageById(vo.getId()));
    }

    @ApiOperation("老师喊单信息")
    @PostMapping("/teacher/order/info")
    public ServerResponse teacherOrderInfo(@RequestBody TeacherOrderInfoVo vo) {
        return ServerResponse.createBySuccess(liveService.selectHanDanByPrimaryKey(vo.getTeacherId()));
    }

    @ApiOperation("老师列表")
    @PostMapping("/teacher/list")
    public ServerResponse teacherList(@RequestBody TeacherListVo vo) {
//        PageHelper.startPage(pageNum, pageSize);
        return ServerResponse.createBySuccess(liveService.selectTeacherList(vo.getPhone()));
    }

    @ApiOperation("老师详情")
    @PostMapping("/teacher/detail")
    public ServerResponse teacherDetail(@RequestBody TeacherDetailVo vo) {
        return ServerResponse.createBySuccess(liveService.selectTeacherByTeacherId(vo.getTeacherId()));
    }

//
//    @ApiOperation("老师详情1")
//    @PostMapping("/teacher/detail/one")
//    public ServerResponse teacherDetailOne(@RequestBody TeacherDetailVo vo) {
//        String accessToken = vo.getAccess_token();
//        int pageNum = vo.getPageNum();
//        int pageSize = vo.getPageSize();
//        String phone = vo.getPhone();
//        Integer teacherId = vo.getTeacherId();
//        logger.debug(accessToken);
//        logger.debug(TAG, pageNum);
//        logger.debug(TAG, pageSize);
//        logger.debug(phone);
//        logger.debug(TAG, teacherId);
//        return ServerResponse.createBySuccess(liveService.selectTeacherByTeacherId( phone, teacherId));
//    }

    @ApiOperation("老师喊单列表")
    @PostMapping("/teacher/order/list")
    public ServerResponse teacherOrderList(@RequestBody PageVo vo) {
//        PageHelper.startPage(pageNum, pageSize);
        return ServerResponse.createBySuccess(liveService.selectHanDanList());
    }


    /**
     * 获取咨询新闻列表
     * <p>
     * 1财经要闻 2研究报告 3独家解读 4市场动态
     */
    @ApiOperation("行情咨询新闻列表")
    @PostMapping("/news/list")
    public ServerResponse newsList(@RequestBody NewsListVo vo) {
//        PageHelper.startPage(pageNum, pageSize);
//        logger.debug("=type==" + type);
        logger.debug("=pageNum==" + vo.getPageNum());
        logger.debug("=pageSize==" + vo.getPageSize());
        IPage<TybZiXun> page = ziXunService.page(new Page<>(vo.getPageNum(), vo.getPageSize()), new QueryWrapper<TybZiXun>()
                .lambda().in(TybZiXun::getType, vo.getType()));
//                .or(e -> e.like(TybZiXun::getName, "张")));
        Page<TybZiXun> pagex =new Page<>(vo.getPageNum(),vo.getPageSize());
//        ziXunService.getOne()
        return ServerResponse.createBySuccess(page);
    }


}
