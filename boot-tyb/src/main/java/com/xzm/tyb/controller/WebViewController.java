package com.xzm.tyb.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * http://localhost:8080/thymeleaf
 */
@Api(tags = "webView部分")
@Controller
@RequestMapping("/h5")
public class WebViewController extends BaseController {
    //   @Autowired
//   private RedisTemplate redisTemplate;
    private final Logger logger = LoggerFactory.getLogger(getClass());


    @ApiOperation("(活动)金色星期三")
    @GetMapping(value = "/act/one")
    public String act1() {
        logger.debug("====");
        return "tyb/activities/golden_wed";
    }

    @ApiOperation("(活动)一元投")
    @GetMapping(value = "/act/two")
    public String act2() {
        return "tyb/activities/one_yuan_invest";
    }

    @ApiOperation("一键开户")
    @GetMapping(value = "/account/open")
    public String accountOpen() {
        return "tyb/activities/open_account";
    }

    @ApiOperation("关于我们")
    @GetMapping(value = "/about")
    public String about() {
        return "tyb/others/about_app";
    }

    @ApiOperation("新闻资讯")
    @RequestMapping(value = "/news", method = RequestMethod.GET)
    public String news() {
        return "tyb/others/news";
    }


}
