package com.xzm.tyb.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * http://localhost:8080/thymeleaf
 */
@Api("webView部分")
@Controller
@RequestMapping("/webView")
public class WebViewController {
//   @Autowired
//   private RedisTemplate redisTemplate;
    private final Logger logger = LoggerFactory.getLogger(getClass());

    /**
     * 金色星期三 活动
     */
    @ApiOperation("金色星期三")
    @RequestMapping(value = "/goldenWed" ,method = RequestMethod.GET)
    public String goldenWed(){
        logger.debug("====");
        return "tyb/activities/golden_wed";
    }

    /**
     * 一元投 活动
     */
    @ApiOperation("一元投")
    @RequestMapping(value = "/oneYuanInvest",method = RequestMethod.GET)
    public String oneYuanInvest(){
        return "tyb/activities/one_yuan_invest";
    }

    /**
     * 一键开户 活动
     */
    @ApiOperation("一键开户")
    @RequestMapping(value = "/openAccount",method = RequestMethod.GET)
    public String openAccount(){
        return "tyb/activities/open_account";
    }

    /**
     * 关于我们
     */
    @ApiOperation("关于我们")
    @RequestMapping(value = "/aboutApp",method = RequestMethod.GET)
    public String aboutApp(){
        return "tyb/others/about_app";
    }
    /**
     * 新闻资讯
     */
    @ApiOperation("新闻资讯")
    @RequestMapping(value = "/news",method = RequestMethod.GET)
    public String news(){
        return "tyb/others/news";
    }


}
