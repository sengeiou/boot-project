package com.xzm.modules.tyb.controller;

import com.xzm.common.entity.ServerResponse;
import com.xzm.modules.tyb.form.TybUserForm;
import com.xzm.modules.tyb.service.TybUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@Api("用户接口")
@RestController
@RequestMapping(value = "/tyb/user")
public class TybUserController {
//    private static final Log logger = LogFactory.getLog(TybUserController.class);
    @Autowired
    private TybUserService userService;

    /**
     * 因为GetMapping 不支持@RequestBody
     */
    @PostMapping(value = "register", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation("注册") // UserForm 前去掉 @RequestBody
    public ServerResponse register(TybUserForm user) {
        return userService.register(user);
    }


    @ApiImplicitParams({
            @ApiImplicitParam(name = "phone", value = "手机号", required = true,
                    dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "password", value = "密码", required = true,
                    dataType = "String", paramType = "query"),
    })
    @ApiOperation("登陆")
    @PostMapping("login")
    public ServerResponse login(@RequestParam("phone") String phone,
                                @RequestParam("password") String password) {
        return userService.login(phone, password);
    }

    @ApiOperation("修改昵称")
    @PostMapping("resetNickName")
    public ServerResponse resetNickName(@RequestParam(value = "access_token") String access_token,
                                        @RequestParam("phone") String phone,
                                        @RequestParam("nick_name") String nick_name) {
        return userService.resetNickName(access_token, phone, nick_name);
    }

    @ApiOperation("获取用户信息")
    @GetMapping("getUserInfo")
    public ServerResponse getUserInfo(@RequestParam(value = "access_token") String access_token,
                                      @RequestParam("phone") String phone) {
        return userService.getUserInfo(access_token, phone);
    }


    @ApiOperation("用户跟单列表")
    @GetMapping("selectGenDanTeacherList")
    public ServerResponse selectGenDanTeacherList(@RequestParam("access_token") String access_token,
                                                  @RequestParam("phone") String phone) {
//        PageHelper.startPage(pageNum, pageSize);
        return userService.selectGenDanTeacherList(access_token, phone);
    }


    @ApiOperation("开户")
    @PostMapping("userKaiHu")
    public ServerResponse selectUserKaiHu(@RequestParam("access_token") String access_token,
                                          @RequestParam(value = "phone",required = false) String phone,
                                          @RequestParam("userName") String userName,
                                          @RequestParam("idCard") String idCard,
                                          @RequestParam("platformCode") String platformCode) {
        return userService.userKaiHu(access_token, phone,userName,idCard,platformCode);
    }
    @ApiOperation("查询开户信息")
    @GetMapping("selectUserKaiHuInfo")
    public ServerResponse selectUserKaiHuInfo(@RequestParam("access_token") String access_token,
                                              @RequestParam(value = "phone",required = false) String phone) {
        return userService.selectUserKaiHuInfo(access_token, phone);
    }
}