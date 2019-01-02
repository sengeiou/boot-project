package com.xzm.tyb.controller;

import com.xzm.modules.test.pojo.UserEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 * Created by xuzongmeng on 2018/3/12.
 */
@RestController
@RequestMapping("/tybtest")
public class TybTestController {
    private final static Logger logger = LoggerFactory.getLogger(TybTestController.class);

    @GetMapping(value ="/websocket")
    public String login(@ModelAttribute UserEntity userEntity, Model model){
        return "1213";
    }

}
