package com.xzm.modules.test.api;



import com.xzm.modules.test.pojo.TestUser;
import com.xzm.modules.test.service.BlogProperties;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by xuzongmeng on 2017/8/15.
 */
//@Configuration
//@controller
@Api("api接口文档")
@Controller
@RequestMapping(value = "/test/api")
public class ApiController {
    private static final Log log =LogFactory.getLog(ApiController.class);
    @Autowired
    private BlogProperties blogProperties;
    @RequestMapping(value = "/getDate",method = RequestMethod.GET)
    @ResponseBody
    public TestUser getDate(){
        TestUser user =new TestUser("xuzongmeng","n男");test();
        return user;
    }


    @ApiImplicitParams({
            @ApiImplicitParam(name = "username", value = "用户ID", required = true,
                    dataType = "String",paramType = "query"),
            @ApiImplicitParam(name = "sex", value = "性别", required = true,
                    dataType = "String",paramType = "query"),
//            @ApiImplicitParam(name = "user", value = "用户实体user",
//                    required = true, dataType = "TestUser")
    })
    @ApiOperation(value="用户单个用户", notes="用户单个用户信息")
    @RequestMapping(value = "/getUser",method = RequestMethod.POST)
    @ResponseBody
    /**
     * @RequestParam("username" ) String username,
       @RequestParam("sex" ) String sex
     */
    public TestUser getUser(@RequestParam("username" ) String username,
                            @RequestParam("sex" ) String sex){

        System.out.println("====username======="+username);
        System.out.println("====sex============"+sex);
        TestUser user =new TestUser("xuzongmeng","n男");
        return user;
    }
    public TestUser getUsers(@RequestParam("username" ) String username,
                             @RequestParam("sex" ) String sex ){

        System.out.println("====username======="+username);
        System.out.println("====sex============"+sex);
        TestUser user =new TestUser("xuzongmeng","n男");
        return user;
    }



    @RequestMapping(value = "/index",method = RequestMethod.GET)
    public ModelAndView inedx(ModelAndView modelAndView){
        TestUser user =new TestUser("xuzongmeng","n男");

        ModelAndView mav=new ModelAndView("index");
        mav.addObject("user", user);
//          mav.getModel().put("name", "caoyc");
        return  mav;
    }

    private  void  test(){
        log.info("随机数测试输出：");
        log.info("随机字符串 : " + blogProperties.getValue());
//        log.info("随机int : " + blogProperties.getNumber());
//        log.info("随机long : " + blogProperties.getBignumber());
//        log.info("随机10以下 : " + blogProperties.getTest1());
//        log.info("随机10-20 : " + blogProperties.getTest2());

    }

}
