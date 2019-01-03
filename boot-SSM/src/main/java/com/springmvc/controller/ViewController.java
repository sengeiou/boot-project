package com.springmvc.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.springmvc.entity.*;
import com.springmvc.service.UserListService;
import com.springmvc.service.UserService;
import com.springmvc.service.impl.EmployeeService;
import org.apache.commons.collections.map.HashedMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/user")
public class ViewController {
//    private Logger logger = Logger.getLogger(ViewController.class);

    //    @Resource(name = "UserService")
    @Resource   /*不要name属性也可以*/
    private UserService userService;


    @Resource(name = "UserListService")
    private UserListService userListService;

    @Autowired
    EmployeeService employeeService;
    /*================================*/
    @RequestMapping("/index")
    public String index() {
        return "index";
    }

    @RequestMapping("/find")
    @ResponseBody
    public Map<String, Object> find(User user, HttpServletRequest request) {

        Map<String, Object> map = new HashedMap();
        System.out.println("你已通过springMVC进入controller方法。。。。");
//        logger.info("你已通过springMVC进入controller方法。。。。");
        String usernames = request.getParameter("username");
        String passwords = request.getParameter("password");
//        logger.debug("用户名=xxx==" + usernames);
//        logger.debug("用户密码=xxxx==" + passwords);
//        logger.debug("用户名===" + user.getUsername());
//        logger.debug("用户密码===" + user.getPassword());
        User query = userService.findByUsernameAndPwd(user.getUsername(), user.getPassword());
//        logger.debug("查询===用户名===" + query.getUsername());
//        logger.debug("查询==用户密码===" + query.getPassword());
        if (query != null) {
            map.put("result", "success");
        } else {
            map.put("result", "fail");
        }
        return map;
    }

    @RequestMapping("/success")
    public String success() {
        return "success";
    }


    @RequestMapping("/ajax")
    public String ajax() {
//        logger.info("登录成功。。。xxxxxxxxxxxxx。");
        return "ajax";
    }


    @RequestMapping("/getUser")

    public String getUser() {
        UserList userList = new UserList(1, "xzm110220784", "哈哈哈",
                "哈哈哈", "哈哈", "男", "23");
//        userListService.insert(userList);
//
        UserList list = userListService.selectByPrimaryKey(6);
//        logger.info("查询11=" + list.getuName());
//        logger.info("查询33=" + list.getuPassword());
//        logger.info("查询44=" + list.getuPhonenumber());
//        logger.info("查询55=" + list.getuSex());
//        logger.info("查询66=" + list.getuAge());
        return "getUser";
    }


    @RequestMapping("/getOneUser")
    @ResponseBody
    public HttpResult<UserList> getUsers() {
        UserList userList = new UserList(1, "xzm110220784", "哈哈哈",
                "哈哈哈", "哈哈", "男", "23");
//        userListService.insert(userList);
        HttpResult<UserList> userListHttpResult = new HttpResult<UserList>();

        userListHttpResult.setResultcode(HttpResult.SUCCESS);
        userListHttpResult.setError_code(HttpResult.EMPUTY);
        userListHttpResult.setReason(HttpResult.MSG_SUCCESS);
        userListHttpResult.setResult(userList);
        return userListHttpResult;
    }




    @RequestMapping("/showUserToJspById/{userId}")
    public String showUser(Model model, @PathVariable("userId") Long userId){
        Student user =null;
        model.addAttribute("user", user);
        return "index";
    }


    /**
     * 跳转登陆页面
     */
    @RequestMapping("/login")
    public String login(){
//        logger.debug("======进入到登陆====");
        return "login";
    }

    /**
     * 跳转登陆页面
     */
    @RequestMapping("/list")
    public String list(){
//        logger.debug("======员工列表1111====");
        return "list";
    }



    /**
     * 跳转员工列表
     */
    @RequestMapping("/empList")
    public String getEmplist(){
//        logger.debug("======员工列表2222====");
        return "emplist";
    }


    /**
     * 导入jackson包。
     * @param pn
     * @return
     */
    @RequestMapping("/emps")
    @ResponseBody
    public Msg getEmpsWithJson(
            @RequestParam(value = "pn", defaultValue = "1") Integer pn) {
        // 这不是一个分页查询
        // 引入PageHelper分页插件
        // 在查询之前只需要调用，传入页码，以及每页的大小
        PageHelper.startPage(pn, 5);
        // startPage后面紧跟的这个查询就是一个分页查询
        List<Employee> emps = employeeService.getAll();
        // 使用pageInfo包装查询后的结果，只需要将pageInfo交给页面就行了。
        // 封装了详细的分页信息,包括有我们查询出来的数据，传入连续显示的页数
        PageInfo page = new PageInfo(emps, 5);
        return Msg.success().add("pageInfo", page);
    }


    /**
     * 跳转员工列表
     */
    @RequestMapping("/goodslist")
    public String goodslist(){
//        logger.debug("======员工列表2222====");
        return "goods/goodslist";
    }




    /**
     *
     */
    @RequestMapping("/manage/index")
    public String manageIndex(){
        return "manage/index";
    }
}
