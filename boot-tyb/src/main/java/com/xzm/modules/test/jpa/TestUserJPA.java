//package com.xzm.modules.test.jpa;
//
//
//import com.xzm.modules.test.pojo.UserEntity;
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
//import org.springframework.data.jpa.repository.Modifying;
//import org.springframework.data.jpa.repository.Query;
//import org.springframework.transaction.annotation.Transactional;
//
//import java.io.Serializable;
//import java.util.List;
//
///**
// * ========================
// * Created with IntelliJ IDEA.
// * TestUser：恒宇少年
// * Date：2017/4/4
// * Time：15:43
// * 码云：http://git.oschina.net/jnyqy
// * ========================
// * JpaRepository需要泛型接口参数，第一个参数是实体，第二则是主键的类型，
// * 意思就是你当前的操作给你抛出了需要事务异常，
// * SpringDataJPA自定义SQL时需要在对应的接口或者调用接口的地方添加事务注解@Transactional，来开启事务自动化管理。
// */
//@Transactional
//public interface TestUserJPA extends JpaRepository<UserEntity,Long>
//{
//    //查询大于20岁的用户
//    @Query(value = "select * from t_user where t_age > ?1",nativeQuery = true)
//    public List<UserEntity> nativeQuery(int age);
//
//    /**
//     * @Query配合@Modifying
//    从名字上可以看到我们的@Query注解好像只是用来查询的，
//    但是如果配合@Modifying注解一共使用，则可以完成数据的删除、添加、更新操作。
//    下面我们来测试下自定义SQL完成删除数据的操作，我根据名字、密码字段共同删除一个数据
//    更新操作时跟删除一致，都需要添加@Query以及@Modifying注解配合使用
//     * @param name
//     * @param pwd
//     */
//    //根据用户名、密码删除一条数据
//    @Modifying
//    @Query(value = "delete from t_user where t_name = ?1 and t_pwd = ?2",nativeQuery = true)
//    public void deleteQuery(String name,String pwd);
//}