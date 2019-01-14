package com.xzm.tyb.controller;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xzm.tyb.common.entity.ServerResponse;
import com.xzm.tyb.dao.TybUserGenDanMapper;
import com.xzm.tyb.service.TybLiveService;
import com.xzm.tyb.service.TybZiXunService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "直播")
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

    @ApiOperation("首页直播室banner")
    @GetMapping("/banner")
    public ServerResponse selectLiveTopList() {
        return liveService.selectLiveTopList();
    }

    @ApiOperation("获取重要消息")
    @GetMapping("/banner/message")
    public ServerResponse selectZiXunList(@RequestParam(defaultValue = "1") int id) {
        return liveService.selectImportantMessageById(id);
    }

    @ApiOperation("老师喊单信息")
    @GetMapping("/teacher/order/info")
    public ServerResponse selectHanDanByPrimaryKey(@RequestParam Integer id) {
        ServerResponse serverResponse = liveService.selectHanDanByPrimaryKey(id);
        return serverResponse;
    }

    @ApiOperation("老师列表")
    @GetMapping("/teacher/list")
    public ServerResponse selectTeacherList(@RequestParam(defaultValue = "1") int pageNum,
                                            @RequestParam(defaultValue = "5") int pageSize,
                                            @RequestParam String access_token,
                                            @RequestParam(value = "phone", required = false) String phone) {
//        PageHelper.startPage(pageNum, pageSize);
        return liveService.selectTeacherList(access_token, phone);
    }

    @ApiOperation("老师详情")
    @GetMapping("/teacher/detail")
    public ServerResponse selectTeacherByTeacherId(@RequestParam(value = "access_token") String access_token,
                                                   @RequestParam(value = "phone", required = false) String phone,
                                                   @RequestParam("teacherId") Integer teacherId) {
        return liveService.selectTeacherByTeacherId(access_token, phone, teacherId);
    }

    @ApiOperation("老师喊单列表")
    @GetMapping("/teacher/order/list")
    public ServerResponse selectHanDanList(@RequestParam(defaultValue = "1") int pageNum,
                                           @RequestParam(defaultValue = "5") int pageSize) {
//        PageHelper.startPage(pageNum, pageSize);
        return liveService.selectHanDanList();
    }


    /**
     * 获取咨询新闻列表
     *
     * @param type 1财经要闻 2研究报告 3独家解读 4市场动态
     */
    @ApiOperation("行情咨询新闻列表")
    @GetMapping("/news/list")
    public ServerResponse selectZiXunList(@RequestParam(defaultValue = "1") int pageNum,
                                          @RequestParam(defaultValue = "5") int pageSize,
                                          @RequestParam(defaultValue = "1") int type, Page page) {
//        PageHelper.startPage(pageNum, pageSize);
        logger.debug("=type==" + type);
        logger.debug("=pageNum==" + pageNum);
        logger.debug("=pageSize==" + pageSize);
//        IPage page1 = ziXunService.page(page);
//        return ziXunService.selectZiXunList(type);
        return ServerResponse.createBySuccess(ziXunService.page(page));

    }


}
