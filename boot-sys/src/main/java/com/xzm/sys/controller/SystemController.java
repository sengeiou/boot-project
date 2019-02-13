package com.xzm.sys.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping(value = "/sys")
public class SystemController {
    @GetMapping(value = "/index")
    public String index(HttpServletRequest request) {
        return "访问到了===SystemController";
    }
}
