package com.xzm.single.controller;

import com.github.pagehelper.PageHelper;
import com.xzm.common.entity.ServerResponse;
import com.xzm.single.dao.TybUserGenDanMapper;
import com.xzm.single.service.TybLiveService;
import com.xzm.single.service.TybZiXunService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 直播首页
 */
@RestController
@RequestMapping(value = "/live")
public class LiveController extends BaseController {
//    private static final Log logger = LogFactory.getLog(LiveController.class);
    @Autowired
    private TybLiveService liveService;
    @Autowired
    private TybZiXunService ziXunService;
    @Autowired
    private TybUserGenDanMapper userGenDanMapper;
    /**
     * 直播室首页数据
     */
    @GetMapping("/selectLiveTopList")
    public ServerResponse selectLiveTopList() {
        return liveService.selectLiveTopList();
    }

    /**
     * 获取单个老师排行
     */
    @GetMapping("/selectHanDanByPrimaryKey")
    public ServerResponse selectHanDanByPrimaryKey(@RequestParam Integer id) {
        ServerResponse serverResponse = liveService.selectHanDanByPrimaryKey(id);
        return serverResponse;
    }
    /**
     * 获取老师列表
     */
    @GetMapping("/selectTeacherList")
    public ServerResponse selectTeacherList(@RequestParam(defaultValue = "1") int pageNum,
                                            @RequestParam(defaultValue = "5") int pageSize,
                                            @RequestParam String access_token,
                                            @RequestParam(value = "phone",required = false) String phone) {
        PageHelper.startPage(pageNum, pageSize);
        return liveService.selectTeacherList(access_token,phone);
    }

    /**
     *根据老师ID查询老师详情
     */
    @GetMapping("/selectTeacherByTeacherId")
    public ServerResponse selectTeacherByTeacherId(@RequestParam(value = "access_token") String access_token,
                                                   @RequestParam(value = "phone",required = false) String phone,
                                                   @RequestParam("teacherId") Integer teacherId) {
        return liveService.selectTeacherByTeacherId(access_token,phone,teacherId);
    }
    /**
     * 获取老师喊单排行
     */
    @GetMapping("/selectHanDanList")
    public ServerResponse selectHanDanList(@RequestParam(defaultValue = "1") int pageNum,
                                           @RequestParam(defaultValue = "5") int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        return liveService.selectHanDanList();
    }


    /**
     * 获取咨询新闻列表
     *
     * @param type 1财经要闻 2研究报告 3独家解读 4市场动态
     */
    @GetMapping("/selectZiXunList")
    public ServerResponse selectZiXunList(@RequestParam(defaultValue = "1") int pageNum,
                                          @RequestParam(defaultValue = "5") int pageSize,
                                          @RequestParam(defaultValue = "1") int type) {
        PageHelper.startPage(pageNum, pageSize);
        logger.debug("=type==" + type);
        logger.debug("=pageNum==" + pageNum);
        logger.debug("=pageSize==" + pageSize);
        return ziXunService.selectZiXunList(type);
    }

    /**
     *获取重要消息
     */
    @GetMapping("/selectImportantMessage")
    public ServerResponse selectZiXunList(@RequestParam(defaultValue = "1") int id) {
        return liveService.selectImportantMessageById(id);
    }

}
