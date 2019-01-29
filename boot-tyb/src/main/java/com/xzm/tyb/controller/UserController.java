package com.xzm.tyb.controller;

import com.xzm.tyb.common.base.BaseController;
import com.xzm.tyb.common.entity.ServerResponse;
import com.xzm.tyb.pojo.vo.*;
import com.xzm.tyb.service.TybUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

//@Api("用户接口")
@Api(tags = "用户")
@RestController
@RequestMapping(value = "/user")
public class UserController extends BaseController {
    //    private static final Log logger = LogFactory.getLog(TybUserController.class);
    @Autowired
    private TybUserService userService;

    /**
     * 因为GetMapping 不支持@RequestBody
     */
    @PostMapping(value = "/register", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation("注册")
    public ServerResponse register(@RequestBody TybUserVo user) {
        return ServerResponse.createBySuccess(userService.register(user));
    }

    @ApiImplicitParams({
            @ApiImplicitParam(name = "phone", value = "手机号", required = true,
                    dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "password", value = "密码", required = true,
                    dataType = "String", paramType = "query"),
    })
    @ApiOperation("登陆")
    @PostMapping("/login")
    public ServerResponse login(@RequestBody LoginVo vo) {
        return ServerResponse.createBySuccess(userService.login(vo.getPhone(), vo.getPassword()));
    }

    @ApiOperation("修改昵称")
    @PostMapping("/nickname/modify")
    public ServerResponse nicknameModify(@RequestBody NiceNameModifyVo vo) {
        return ServerResponse.createBySuccess(userService.resetNickName(vo.getPhone(), vo.getNickName()));
    }

    @ApiOperation("获取用户信息")
    @PostMapping("/info")
    public ServerResponse info(@RequestBody UserVo vo) {
        return ServerResponse.createBySuccess(userService.getUserInfo(vo.getPhone()));
    }


    @ApiOperation("用户跟单列表")
    @PostMapping("/order/list")
    public ServerResponse orderList(@RequestBody UserVo vo) {
//        PageHelper.startPage(pageNum, pageSize);
        return ServerResponse.createBySuccess(userService.selectGenDanTeacherList(vo.getPhone()));
    }

    @ApiOperation("开户")
    @PostMapping("/account/open")
    public ServerResponse accountOpen(@RequestBody AccountOpenVo vo) {
        return ServerResponse.createBySuccess(userService.userKaiHu(String.valueOf(vo.getPhone()),
                vo.getUserName(), String.valueOf(vo.getIdCard()), vo.getPlatformCode()));
    }

    @ApiOperation("查询开户信息")
    @PostMapping("/account/info")
    public ServerResponse accountInfo(@RequestBody UserVo vo) {
        return ServerResponse.createBySuccess(userService.selectUserKaiHuInfo(vo.getPhone()));
    }
}
