package com.xzm.single.controller;

import com.xzm.modules.test.pojo.UserEntity;
import io.swagger.annotations.Api;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by xuzongmeng on 2018/3/12.
 */
@Api(tags ="直播")
@RestController
@RequestMapping("/test")
public class TybTestController {
    private final static Logger logger = LoggerFactory.getLogger(TybTestController.class);

    @GetMapping(value ="/index")
    public String index(@ModelAttribute UserEntity userEntity, Model model){
        return "1213";
    }

}
