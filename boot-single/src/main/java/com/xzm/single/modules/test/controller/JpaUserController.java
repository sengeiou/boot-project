//package com.xzm.modules.test.controller;
//
//
//
//import com.xzm.modules.test.jpa.UserJPA;
//import com.xzm.modules.test.pojo.TestUser;
//import com.xzm.modules.test.pojo.UserEntity;
//import com.xzm.modules.test.service.UserService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.jpa.domain.Specification;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RestController;
//
//import javax.persistence.criteria.CriteriaBuilder;
//import javax.persistence.criteria.CriteriaQuery;
//import javax.persistence.criteria.Predicate;
//import javax.persistence.criteria.Root;
//import javax.servlet.http.HttpServletRequest;
//import java.util.List;
//
///**
// * ========================
// * Created with IntelliJ IDEA.
// * TestUser：恒宇少年
// * Date：2017/4/4
// * Time：15:36
// * 码云：http://git.oschina.net/jnyqy
// * ========================
// */
//@RestController
//@RequestMapping(value = "/test/jpaUser")
//public class UserController {
//
//    @Autowired
//    private UserJPA userJPA;
//
//    @Autowired
//    private UserService userService;
//
//    /**
//     * Redis缓存测试
//     * @return
//     */
//    @RequestMapping(value ="/listRedis" ,method = RequestMethod.GET)
//    public List<UserEntity> listRedis(){
//        return userService.list();
//    }
//
//    /**
//     * 查询用户列表方法
//     * @return
//     */
//    @RequestMapping(value ="/list" ,method = RequestMethod.GET)
//    public List<UserEntity> list(){
//        return userJPA.findAll();
//    }
//
//    /**
//     * 添加、更新用户方法
//     * @param entity
//     * @return
//     * http://127.0.0.1:8080/user/save?name=admin&age=22&address=jinan
//     */
//    @RequestMapping(value = "/save",method = RequestMethod.POST)
//    public UserEntity save(UserEntity entity)
//    {
//        return userJPA.save(entity);
//    }
//
//    /**
//     * 删除用户方法
//     * @param id 用户编号
//     * @return
//     */
//    @RequestMapping(value = "/delete",method = RequestMethod.GET)
//    public List<UserEntity> delete(Long id)
//    {
//        userJPA.delete(id);
//        return userJPA.findAll();
//    }
//
//    @RequestMapping(value = "/getUser",method = RequestMethod.GET)
//
//    public TestUser getUser(){
////        @RequestParam("username" ) String username,
////        @RequestParam("sex" ) String sex
////        System.out.println("====username======="+username);
////        System.out.println("====sex============"+sex);
//        TestUser user =new TestUser("xuzongmeng","n男");
//        return user;
//    }
//
//
//    @RequestMapping(value = "/login")
//    public String login(UserEntity user, HttpServletRequest request)
//    {
//        System.out.println("====");
//        //登录成功
//        boolean flag = true;
//        String result = "登录成功";
//        //根据用户名查询用户是否存在
//        UserEntity userEntity = userJPA.findOne(new Specification<UserEntity>() {
//            @Override
//            public Predicate toPredicate(Root<UserEntity> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
//                criteriaQuery.where(criteriaBuilder.equal(root.get("name"), user.getName()));
//                return null;
//            }
//        });
//        //用户不存在
//        if(userEntity == null){
//            flag = false;
//            result = "用户不存在，登录失败";}
//        //密码错误
//        else if(!userEntity.getPwd().equals(user.getPwd())){
//            flag = false;
//            result = "用户密码不相符，登录失败";
//        }
//        //登录成功
//        if(flag){
//            //将用户写入session
//            request.getSession().setAttribute("_session_user",userEntity);
//        }
//        return result;
//    }
//
//}
