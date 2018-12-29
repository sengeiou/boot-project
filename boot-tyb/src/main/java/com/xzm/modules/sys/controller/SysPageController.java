package com.xzm.modules.sys.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 系统页面视图
 *
 * @author ZhouChenglin
 * @email yczclcn@163.com
 * @url www.chenlintech.com
 * @date 2017年8月9日 下午3:33:00
 */
@Controller
//@RequestMapping("/sys/page")
public class SysPageController {
    private static final Log logger = LogFactory.getLog(SysPageController.class);

    /**
     * 访问: http://localhost:8888/sys/page/login
     *
     * @return
     */
//	@RequestMapping("login")
//	public String index() {
//		logger.debug("==请求系统页面==login==");
//		return "login";
//	}
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index() {
        logger.debug("======进入登录页面==111==");
        return "login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login() {
        logger.debug("======进入登录页面==222==");
        return "login";
    }

    /**
     * 页面跳转
     *
     * @param module
     * @param function
     * @param url
     * @return
     */
    @RequestMapping("{module}/{function}/{url}.html")
    public String page(@PathVariable("module") String module, @PathVariable("function") String function,
                       @PathVariable("url") String url) {
//		logger.debug("==请求系统页面==111==");
        logger.debug("==请求系统页面==111==module==" + module);
        logger.debug("==请求系统页面==111==function==" + function);
        logger.debug("==请求系统页面==111==url==" + url);
        return module + "/" + function + "/" + url;
    }

    /**
     * 页面跳转
     *
     * @param module
     * @param url
     * @return
     */
    @RequestMapping("{module}/{url}.html")
    public String page(@PathVariable("module") String module,
                       @PathVariable("url") String url) {
        logger.debug("==请求系统页面==222==module==" + module);
//        logger.debug("==请求系统页面==222==function==" + function);
        logger.debug("==请求系统页面==22==url==" + url);
        return module + "/" + url;
    }

}
