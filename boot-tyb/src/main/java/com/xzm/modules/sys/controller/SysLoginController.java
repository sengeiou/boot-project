package com.xzm.modules.sys.controller;

//import net.chenlin.dp.common.annotation.SysLog;
//import net.chenlin.dp.common.entity.R;
//import net.chenlin.dp.common.utils.MD5Utils;
//import net.chenlin.dp.common.utils.ShiroUtils;
//import net.chenlin.dp.modules.sys.entity.SysUserEntity;
//import net.chenlin.dp.modules.sys.service.SysUserService;

import com.xzm.common.annotation.SysLog;
import com.xzm.common.entity.R;
import com.xzm.common.utils.MD5Utils;
import com.xzm.common.utils.ShiroUtils;
import com.xzm.modules.sys.entity.SysUserEntity;
import com.xzm.modules.sys.service.SysUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * 用户controller
 *
 * @author ZhouChenglin
 * @email yczclcn@163.com
 * @url www.chenlintech.com
 * @date 2017年8月8日 下午2:48:50
 */
@RestController
@RequestMapping("/sys")
public class SysLoginController extends AbstractController {
    //logback
    private final static Logger logger = LoggerFactory.getLogger(SysLoginController.class);
    @Autowired
    private SysUserService sysUserService;

    /**
     * 登录
     */
    @SysLog("登录")
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public R login(String username, String password, HttpServletRequest request) throws IOException {
        SysUserEntity user = sysUserService.getByUserName(username);
        password = MD5Utils.encrypt(username, password);
        logger.debug("登录==" + user.toString());
        if (user == null || !user.getPassword().equals(password)) {
            return R.error("用户名或密码错误");
        }

        if (user.getStatus() == 0) {
            return R.error("账号已被锁定,请联系管理员");
        }
        R token = sysUserService.saveUserToken(user.getUserId());
        request.getSession().setAttribute("current_user",token);
        logger.debug("登录=222=" + token);
        return token;
    }

    /**
     * 退出
     */
    @SysLog("退出系统")
    @RequestMapping(value = "/logout", method = RequestMethod.POST)
    public R logout() {
        R r = sysUserService.updateUserToken(getUserId());
        ShiroUtils.logout();
        return r;
    }

}
