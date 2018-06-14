package com.xzm.modules.test.controller;
import com.xzm.modules.test.pojo.UserEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * ========================
 * Created with IntelliJ IDEA.
 * TestUser：恒宇少年
 * Date：2017/4/4
 * Time：15:36
 * 码云：http://git.oschina.net/jnyqy
 * ========================
 */
@Controller
@RequestMapping(value = "/test/login")
public class LoginController {
    private final Logger logger = LoggerFactory.getLogger(getClass());

    @RequestMapping(value ="/login" ,method = RequestMethod.POST)
    public String login(@ModelAttribute UserEntity userEntity,Model model){
        logger.debug("登陆请求==debug==" + userEntity.getName() + "===" + userEntity.getPwd());
        logger.error("登陆请求==error==" + userEntity.getName() + "===" + userEntity.getPwd());
        logger.info("登陆请求==info==" + userEntity.getName() + "===" + userEntity.getPwd());
        logger.trace("登陆请求==trace==" + userEntity.getName() + "===" + userEntity.getPwd());
        logger.warn("登陆请求==warn==" + userEntity.getName() + "===" + userEntity.getPwd());
//        System.out.println("登陆请求=xxxx==" + userEntity.getName() + "===" + userEntity.getPwd());
        model.addAttribute("login_user","徐宗萌");

        return "login";
    }

}
