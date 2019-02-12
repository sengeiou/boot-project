package com.xzm.tyb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;
import javax.servlet.http.HttpServletRequest;
@ApiIgnore
@Controller
@RequestMapping(value = "/jsp")
public class JspController {
    @RequestMapping("/login")
    public String login(HttpServletRequest request) {
        return "login_jsp";
    }
}
