package com.boot.common.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping(value = "/common")
public class CommonController extends AbstractController {
    @RequestMapping(value = "/index")
    public String index(HttpServletRequest request) {
        return "访问到了===commonController";
    }
}
