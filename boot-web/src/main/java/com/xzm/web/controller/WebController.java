package com.xzm.web.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping(value = "web")
public class WebController {
    @RequestMapping(value = "/index")
    public String index(HttpServletRequest request) {
        return "访问到了===WebController";
    }
}
