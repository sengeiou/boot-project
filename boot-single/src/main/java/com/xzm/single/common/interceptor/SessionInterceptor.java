package com.xzm.single.common.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * ========================
 * Created with IntelliJ IDEA.
 * TestUser：恒宇少年
 * Date：2017/4/7
 * Time：21:38
 * 码云：http://git.oschina.net/jnyqy
 * ========================
 */
public class SessionInterceptor implements HandlerInterceptor
{
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object o) throws Exception {
        System.out.println(request.getRequestURI());
        //登录不做拦截
        if(request.getRequestURI().equals("/user/login")
                || request.getRequestURI().equals("/user/login_view"))
        {
            System.out.println("===不做拦截");
            return true;
        }
        //验证session是否存在
        Object obj = request.getSession().getAttribute("_session_user");
//        if(obj == null)
//        {
//            System.out.println("===还没有登录");
//            response.sendRedirect("/user/login_view");
//            return false;
//        }

//        System.out.println("===已经登录");
//        response.sendRedirect("/user/index");
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
