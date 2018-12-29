package com.xzm.jdt.controller;
import com.xzm.jdt.vo.UserVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.*;

//import com.github.pagehelper.PageHelper;

/**
 * 直播首页
 */
@Api("直播首页")
@RestController
@RequestMapping(value = "/live")
public class LiveController {
    private Logger loggerx = Logger.getLogger(LiveController.class);
    private static final Log logger = LogFactory.getLog(LiveController.class);

    /**
     * 直播室首页数据
     */
    @ApiOperation("老师")
    @PostMapping("/teacher")
    public UserVo selectLiveTopList(UserVo userVo) {
        return new UserVo(userVo.getUserId(),userVo.getUserName());
    }


    /**
     * 直播室首页数据
     */
    @ApiOperation("老师1")
    @PostMapping("/teacher1")
    public UserVo teacher1(@RequestBody UserVo userVo) {
        return new UserVo(userVo.getUserId(),userVo.getUserName());
    }

}
