package com.xzm.jdt.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;

import javax.servlet.http.HttpServletRequest;
@ApiIgnore
@RestController
@RequestMapping(value = "/web")
public class WebController {
    @RequestMapping(value = "/index")
    public String index(HttpServletRequest request) {
        return "访问到了===WebController";
    }
}
