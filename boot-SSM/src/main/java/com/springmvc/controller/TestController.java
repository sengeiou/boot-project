package com.springmvc.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.springmvc.entity.Employee;
import com.springmvc.entity.UserList;
import com.springmvc.service.TestUserListService;
import com.springmvc.service.impl.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by vitelon on 2016/12/3.
 */
@Controller
@RequestMapping("/test")
public class TestController {
//    private Logger logger = Logger.getLogger(TestController.class);
    @Autowired
    EmployeeService employeeService;
    @Autowired
    private TestUserListService testUserListServices;
    /**
     * @ResponseBody 该注解可以把map自动转换成json格式给前台
     */
    @RequestMapping(value = "/ajax",method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public Map ajax(HttpServletRequest request){

        Map mapJson = new HashMap();
        String person;
        String optValues = request.getParameter("opt_values");
        if ("1".equals(optValues)){
            person = "姓名：张三，年龄：24，性别：男，出生地：广西南宁";
            mapJson.put("person",person);
        }
        if ("2".equals(optValues)){
            person = "姓名：李四，年龄：30，性别：男，出生地：广西百色";
            mapJson.put("person",person);
        }
        if ("3".equals(optValues)){
            person = "姓名：王五，年龄29，性别：男，出生地：广西桂林";
            mapJson.put("person",person);
        }
        return mapJson;
    }








    @RequestMapping("/getTestUser")
    public String getTestUser(){
//        UserList userLists=new UserList(1,"xzm110220784","哈哈哈",
//              "哈哈哈", "哈哈", "xx", "23");

//        UserList lists = null;
//        UserList list = null;
//        logger.info("查询11="+list.getUName());
//        logger.info("查询22="+list.getUName());
//        logger.info("查询33="+list.getUPassword());
//        logger.info("查询44="+list.getUPhonenumber());
//        logger.info("查询55="+list.getUSex());
//        logger.info("查询66="+list.getUAge());
        UserList list = testUserListServices.selectByPrimaryKey(6);
//        logger.info("查询11="+list.getuName());
//        logger.info("查询33="+list.getuPassword());
//        logger.info("查询44="+list.getuPhonenumber());
//        logger.info("查询55="+list.getuSex());
//        logger.info("查询66="+list.getuSex());
        return "getUser";
    }




    /**
     * 查询员工数据（分页查询）
     *
     * @return
     */
    @RequestMapping("/getEmp")
    public String getEmp(@RequestParam(value = "pn", defaultValue = "1") Integer pn, Model model) {
        // 在查询之前只需要调用，传入页码，以及每页的大
        PageHelper.startPage(pn, 5);
        // startPage后面紧跟的这个查询就是一个分页查询
        List<Employee> emps = employeeService.getAll();
        for (int i = 0; i < emps.size(); i++) {
//            logger.debug("查询员工=="+emps.get(i).getEmpName());;
            System.out.println("===");
        }
        // 使用pageInfo包装查询后的结果，只需要将pageInfo交给页面就行了。
        // 封装了详细的分页信息,包括有我们查询出来的数据，传入连续显示的页数
        PageInfo page = new PageInfo(emps, 5);
        model.addAttribute("pageInfo", page);

        return "list";
    }

}
