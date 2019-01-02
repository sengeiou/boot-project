package com.xzm.tyb.controller;

//import com.baomidou.mybatisplus.plugins.pagination.PageHelper;
//import com.github.pagehelper.PageHelper;
import com.xzm.common.entity.ServerResponse;
import com.xzm.common.utils.JSONUtils;
import com.xzm.modules.common.service.RedisService;
import com.xzm.modules.tyb.service.TybLiveService;
import com.xzm.modules.tyb.service.TybZiXunService;
import com.xzm.modules.tyb.vo.LiveTopVo;
import com.xzm.modules.tyb.vo.TybImportantMessageVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 直播首页
 */
@Api("直播首页")
@RestController
@RequestMapping("/live")
public class LiveController  extends BaseController{
    @Autowired
    private TybLiveService liveService;
    @Autowired
    private TybZiXunService ziXunService;
    @Autowired
    private RedisService redisService;
    /**
     * 获取咨询新闻列表
     * @param type 1财经要闻 2研究报告 3独家解读 4市场动态
     */
    @ApiOperation("获取咨询新闻列表")
    @GetMapping("/news/list")
    public ServerResponse selectZiXunList(@RequestParam(defaultValue = "1") int pageNum,
                                          @RequestParam(defaultValue = "5") int pageSize,
                                          @RequestParam(defaultValue = "1") int type) {
//        PageHelper.startPage(pageNum, pageSize);
        logger.debug("=type==" + type);
        logger.debug("=pageNum==" + pageNum);
        logger.debug("=pageSize==" + pageSize);
        return ziXunService.selectZiXunList(type);
    }

    /**
     * 获取重要消息
     */
    @ApiOperation("获取重要消息")
    @GetMapping("/message")
    public ServerResponse selectZiXunList(@RequestParam(defaultValue = "1") int id) {
        ServerResponse<TybImportantMessageVo> importantMessage = liveService.selectImportantMessageById(id);
        String json = JSONUtils.beanToJson(importantMessage);
        redisService.set("importantMessage", json);
        return liveService.selectImportantMessageById(id);
    }


    /**
     * 直播室首页数据
     */
    @ApiOperation("首页三个直播室")
    @GetMapping("/top/room")
    public ServerResponse selectLiveTopList() {
//        String topList1 = redisService.get("TopList");
        ServerResponse<LiveTopVo> topList = liveService.selectLiveTopList();
        String json = JSONUtils.beanToJson(topList);
        redisService.set("TopList", json);
        return liveService.selectLiveTopList();
    }

    /**
     * 获取单个老师排行
     */
    @ApiOperation("获取单个老师排行")
    @GetMapping("/teacher/handan")
    public ServerResponse selectHanDanByPrimaryKey(@RequestParam Integer id) {
        ServerResponse serverResponse = liveService.selectHanDanByPrimaryKey(id);
        return serverResponse;
    }

    /**
     * 获取老师列表
     */
    @ApiOperation("获取人气老师列表")
    @GetMapping("/teacher/list")
    public ServerResponse selectTeacherList(@RequestParam(defaultValue = "1") int pageNum,
                                            @RequestParam(defaultValue = "5") int pageSize,
                                            @RequestParam String access_token,
                                            @RequestParam(value = "phone", required = false) String phone) {
//        PageHelper.startPage(pageNum, pageSize);
        return liveService.selectTeacherList(access_token, phone);
    }

    /**
     * 根据老师ID查询老师详情
     */
    @ApiOperation("根据老师ID查询老师详情")
    @GetMapping("/teacher/detail")
    public ServerResponse selectTeacherByTeacherId(@RequestParam(value = "access_token") String access_token,
                                                   @RequestParam(value = "phone", required = false) String phone,
                                                   @RequestParam("teacherId") Integer teacherId) {
        return liveService.selectTeacherByTeacherId(access_token, phone, teacherId);
    }

    /**
     * 获取老师喊单排行
     */
    @ApiOperation("获取老师喊单排行")
    @GetMapping("/handan/list")
    public ServerResponse selectHanDanList(@RequestParam(defaultValue = "1") int pageNum,
                                           @RequestParam(defaultValue = "5") int pageSize) {
//        PageHelper.startPage(pageNum, pageSize);


        return liveService.selectHanDanList();
    }



}
