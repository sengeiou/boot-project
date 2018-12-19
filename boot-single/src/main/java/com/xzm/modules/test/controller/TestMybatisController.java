package com.xzm.modules.test.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/test/testMybatis")
public class TestMybatisController {
//
//
//    @Autowired
//    UserMapper userMapper;
//    @Autowired
//    TUserMapper tUserMapper;
//    @Autowired
//    OrdersMapperCustom ordersMapperCustom;
//    @DataSource(name = DataSourceNames.FIRST)
//    @GetMapping("findUserList")
//    public ServerResponse findUserList() {
//        //创建包装对象，设置查询条件
//        UserQueryVo userQueryVo = new UserQueryVo();
//        UserCustom userCustom = new UserCustom();
//        //因为设置了动态的sql，如果不设置某个值，那么条件就不会拼接在sql上
//        userCustom.setSex("男");
//        userCustom.setUsername("三");
//
//        //传入多个id
//        List<Integer> ids = new ArrayList<>();
//        ids.add(1);
//        ids.add(10);
//        ids.add(16);
//        userQueryVo.setIds(ids);
//        userQueryVo.setUserCustom(userCustom);
//        //调用UserMapper的方法
//        List<UserCustom> userList = userMapper.findUserList(userQueryVo);
//        return ServerResponse.createBySuccess(userList);
//    }
//    @DataSource(name = DataSourceNames.FIRST)
//    @GetMapping("findTUserFirst")
//    public ServerResponse findUser1(@RequestParam Integer id) {
//        TUser user = tUserMapper.selectByPrimaryKey(id);
//        return ServerResponse.createBySuccess(user);
//    }
//    @DataSource(name = DataSourceNames.SECOND)
//    @GetMapping("findTUserSecond")
//    public ServerResponse findUser2(@RequestParam Integer id) {
//        TUser user = tUserMapper.selectByPrimaryKey(id);
//        return ServerResponse.createBySuccess(user);
//    }
//
//    /**
//     * 默认数据库1
//     */
//    @SysLog("测试切面日志")
//    @GetMapping("findTUserDefault")
//    public ServerResponse findTUserDefault(@RequestParam Integer id) {
//        TUser user = tUserMapper.selectByPrimaryKey(id);
//        return ServerResponse.createBySuccess(user);
//    }

}
