package com.xzm.tyb.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xzm.tyb.common.base.BaseController;
import com.xzm.tyb.common.entity.ServerResponse;
import com.xzm.tyb.pojo.entity.Employee;
import com.xzm.tyb.pojo.entity.TybZiXun;
import com.xzm.tyb.pojo.vo.PageVo;
import com.xzm.tyb.service.ZiXunService;
import com.xzm.tyb.utils.Resp;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Api(tags = "测试")
@RestController
@RequestMapping(value = "/test")
public class TestController extends BaseController {
    @Autowired
    private ZiXunService ziXunService;

    /**
     * 获取咨询新闻列表
     */
    @GetMapping("/test1")
    public Resp test1(@RequestParam(defaultValue = "1") int pageNum,
                      @RequestParam(defaultValue = "10") int pageSize) {

        logger.debug("=pageNum==" + pageNum);
        logger.debug("=pageSize==" + pageSize);
        List<TybZiXun> list = ziXunService.list();
        return Resp.success(list, 5l, 1, 3);
//      return Resp.s(ziXunService.page(page));

    }

    /**
     * 获取咨询新闻列表
     */
    @GetMapping("/test2")
    public Resp test2() {
//        List<TybZiXun> list = ziXunService.list();
        String str = null;
        System.out.println(str.length());
        return Resp.success(Resp.success("哈哈哈"));
    }

    /**
     * 获取咨询新闻列表
     */
    @PostMapping("/test3")
    public ServerResponse test3(@RequestBody PageVo vo) {
//        List<TybZiXun> list = ziXunService.list();
        Page<TybZiXun> page = new Page<>(vo.getPageNum(), vo.getPageSize());
//        QueryWrapper<TybZiXun> diseaseQueryWrapperw = new QueryWrapper<>();
//        UpdateWrapper<TybZiXun> updateWrapper = new UpdateWrapper<>();
////        updateWrapper.
//        IPage<TybZiXun> page1 = diseaseQueryWrapperw.select(page, diseaseQueryWrapperw);


//        TybUser tybUser = userMapper.selectOne(new QueryWrapper<TybUser>()
//                .lambda().eq(TybUser::getPhone,phone));
//        Integer type = new TybZiXun().getType();
//        LambdaQueryWrapper<TybZiXun> queryWrapper = new QueryWrapper<>().lambda().eq(TybZiXun::getType, 1);

        IPage<TybZiXun> page1 = ziXunService.page(page, new QueryWrapper<TybZiXun>()
                .lambda().eq(TybZiXun::getType, 1));
        return ServerResponse.createBySuccess(page1);
    }


    @GetMapping(value = "/emp/{id}")
    @ResponseBody
    public ServerResponse emp(@PathVariable("id") Integer id) {
        return ServerResponse.createBySuccess(id);
    }

    @PostMapping(value = "/emp1/{id}")
    @ResponseBody
    public ServerResponse emp1(@PathVariable("id") Integer id) {
        return ServerResponse.createBySuccess(id);
    }


    /**
     * 如果直接发送ajax=PUT形式的请求
     * 封装的数据
     * Employee
     * [empId=1014, empName=null, gender=null, email=null, dId=null]
     * <p>
     * 问题：
     * 请求体中有数据；
     * 但是Employee对象封装不上；
     * update tbl_emp  where emp_id = 1014;
     * <p>
     * 原因：
     * Tomcat：
     * 1、将请求体中的数据，封装一个map。
     * 2、request.getParameter("empName")就会从这个map中取值。
     * 3、SpringMVC封装POJO对象的时候。
     * 会把POJO中每个属性的值，request.getParamter("email");
     * AJAX发送PUT请求引发的血案：
     * PUT请求，请求体中的数据，request.getParameter("empName")拿不到
     * Tomcat一看是PUT不会封装请求体中的数据为map，只有POST形式的请求才封装请求体为map
     * org.apache.catalina.connector.Request--parseParameters() (3111);
     * <p>
     * protected String parseBodyMethods = "POST";
     * if( !getConnector().isParseBodyMethod(getMethod()) ) {
     * success = true;
     * return;
     * }
     * <p>
     * <p>
     * 解决方案；
     * 我们要能支持直接发送PUT之类的请求还要封装请求体中的数据
     * 1、配置上HttpPutFormContentFilter；
     * 2、他的作用；将请求体中的数据解析包装成一个map。
     * 3、request被重新包装，request.getParameter()被重写，就会从自己封装的map中取数据
     * 员工更新方法
     *
     * @param employee
     * @return
     */
    @ResponseBody
    @GetMapping(value = "/emp2")
    public ServerResponse saveEmp(Employee employee, HttpServletRequest request) {
        return ServerResponse.createBySuccess(employee);
    }


    /**
     */
    @RequestMapping(value = "/map", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public Map map(HttpServletRequest request) {

        Map map = new HashMap();
        String person;
        String optValues = request.getParameter("opt_values");
        if ("1".equals(optValues)) {
            person = "姓名：张三，年龄：24，性别：男，出生地：广西南宁1";
            map.put("person", person);
        }
        if ("2".equals(optValues)) {
            person = "姓名：李四，年龄：30，性别：男，出生地：广西百色";
            map.put("person", person);
        }
        if ("3".equals(optValues)) {
            person = "姓名：王五，年龄29，性别：男，出生地：广西桂林";
            map.put("person", person);
        }
        return map;
    }


//    /**
//     */
//    @RequestMapping("/emps")
//    @ResponseBody
//    public ServerResponse getEmpsWithJson(
//            @RequestParam(value = "pn", defaultValue = "1") Integer pn) {
//        // 这不是一个分页查询
//        // 引入PageHelper分页插件
//        // 在查询之前只需要调用，传入页码，以及每页的大小
//        PageHelper.startPage(pn, 5);
//        // startPage后面紧跟的这个查询就是一个分页查询
//        List<Employee> emps = employeeService.getAll();
//        // 使用pageInfo包装查询后的结果，只需要将pageInfo交给页面就行了。
//        // 封装了详细的分页信息,包括有我们查询出来的数据，传入连续显示的页数
//        PageInfo page = new PageInfo(emps, 5);
//        return ServerResponse.createBySuccess(null);
//    }

    @RequestMapping(value = "/emp21")
    public String saveEmp1() {
        return "login_jsp";
    }
}
