package com.xzm.modules.test.controller;

import com.xzm.modules.test.pojo.TestUser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

/**
 * ========================
 * Created with IntelliJ IDEA.
 * TestUser：恒宇少年
 * Date：2017/4/3
 * Time：16:44
 * 码云：http://git.oschina.net/jnyqy
 * ========================
 */

/**
 * http://localhost:8080/thymeleaf
 *
 * http://127.0.0.1:8080/thymeleaf
 * 在host文件下添加 然后http://idea.lanyus.com/获取激活
 * 0.0.0.0  account.jetbrains.com
 * xxxx
 *
 */
@Controller
@RequestMapping("/test/index")
public class IndexController {

    private final Logger logger = LoggerFactory.getLogger(getClass());
//    /**
//     * 页面跳转
//     * @param module
//     * @param function
//     * @param url
//     * @return
//     */
//    @RequestMapping("{module}/{function}/{url}.html")
//    public String page(@PathVariable("module") String module, @PathVariable("function") String function,
//                       @PathVariable("url") String url) {
//        return module + "/" + function + "/" + url;
//    }
//
//    /**
//     * 页面跳转
//     * @param module
//     * @param url
//     * @return
//     */
//    @RequestMapping("{module}/{url}.html")
//    public String page(@PathVariable("module") String module, @PathVariable("url") String url) {
//        return module + "/" + url;
//    }

    /**
     * 访问webapp/jsp/index.jsp文件
     * @return
     */
    @RequestMapping(value = "/index_iframe",method = RequestMethod.GET)
    public String index_iframe(){
        return "test/index_iframe";
    }
    @RequestMapping(value = "/",method = RequestMethod.GET)
    public String index(){
        logger.debug("======进入登录页面==111==");
        return "login";
    }
    @RequestMapping(value = "/login",method = RequestMethod.GET)
    public String login(){
        logger.debug("======进入登录页面==222==");
        return "login";
    }
    /**
     * 初始化登录页面
     * @return
     */
    @RequestMapping(value = "/login_view",method = RequestMethod.GET)
    public String login_view(){
        return "login";
    }

    @RequestMapping(value = "/thymeleaf",method = RequestMethod.GET)
    public String thymeleaf(ModelAndView modelAndView, Model model,Map<String,Object> map){
       TestUser user =new TestUser("xuzongmeng==","男");
      System.out.println("===xuzongmeng==");
        model.addAttribute("testUser", user);
//        map.put("user","xuzongmeng==thymeleaf");
        return  "test/thymeleaf";
    }

    /**
     *
     */
    @RequestMapping(value = "/indexTest",method = RequestMethod.GET)
    public String indexTest(Model model){
         String  user="徐宗萌";
         model.addAttribute("login_user",user);
        return "test/index";
    }

    @RequestMapping(value = "/freemarker",method = RequestMethod.GET)
//    @ResponseBody
    public String freemarker(Map<String,Object> map){
        map.put("name", "xuzonemeng====freemarker");
        return "test/freemarker";
    }

    /**
     * 去掉thymeleaf依赖 jsp视图渲染就能生效
     */

    @RequestMapping(value = "/jsp",method = RequestMethod.GET)
//    @ResponseBody
    public String jsp(Map<String,Object> map,Model model ){
        TestUser user =new TestUser("xuzongmeng==JSP页面","n男");
//        ModelAndView mav=new ModelAndView("index");
        model.addAttribute("jspKey",user);
        return "login_jsp";
    }
}
