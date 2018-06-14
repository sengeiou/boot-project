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
 * Created by xuzongmeng on 2018/3/12.
 */
@Controller
@RequestMapping("/test/test")
public class TestController {
    //logback
    private final static Logger logger = LoggerFactory.getLogger(TestController.class);
//    @Autowired
//    TUserService tUserService;
//
//    @GetMapping(value = "/getTUser")
//    @ResponseBody
//    public TUser save(@RequestParam Integer id)
//    {
//        logger.debug("=====sdzSd=" + id);
//        TUser tUser = tUserService.selectByPrimaryKey(id);
//        return  tUser;
//    }
    @RequestMapping(value ="/websocket" ,method = RequestMethod.GET)
    public String login(@ModelAttribute UserEntity userEntity, Model model){
        return "websocket";
    }

}
