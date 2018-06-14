package com.xzm.modules.tyb.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
/**
 * http://localhost:8080/thymeleaf
 */
@Controller
@RequestMapping("/tyb/webView")
public class WebViewController {
//   @Autowired
//   private RedisTemplate redisTemplate;
    private final Logger logger = LoggerFactory.getLogger(getClass());

    /**
     * 金色星期三 活动
     */
    @RequestMapping(value = "/goldenWed")
    public String goldenWed(){
        logger.debug("====");
        return "tyb/activities/golden_wed";
    }

    /**
     * 一元投 活动
     */
    @RequestMapping(value = "/oneYuanInvest")
    public String oneYuanInvest(){
        return "tyb/activities/one_yuan_invest";
    }

    /**
     * 一键开户 活动
     */
    @RequestMapping(value = "/openAccount")
    public String openAccount(){
        return "tyb/activities/open_account";
    }

    /**
     * 关于我们
     */
    @RequestMapping(value = "/aboutApp")
    public String aboutApp(){
        return "tyb/others/about_app";
    }
    /**
     * 新闻资讯
     */
    @RequestMapping(value = "/news")
    public String news(){
        return "tyb/others/news";
    }


}
