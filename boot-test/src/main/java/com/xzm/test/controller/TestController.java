package com.xzm.test.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping(value = "test")
public class TestController {
    @RequestMapping(value = "/index")
    public String index(HttpServletRequest request) {
        return "访问到了===TestController";
    }
}
