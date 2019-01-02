///*
// * Copyright (c) 2017. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
// * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
// * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
// * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
// * Vestibulum commodo. Ut rhoncus gravida arcu.
// */
//
//package com.xzm.config;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.boot.autoconfigure.orm.jpa.JpaProperties;
//import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
//import org.springframework.orm.jpa.JpaTransactionManager;
//import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
//import org.springframework.transaction.PlatformTransactionManager;
//import org.springframework.transaction.annotation.EnableTransactionManagement;
//
//import javax.persistence.EntityManager;
//import javax.sql.DataSource;
//import java.util.Map;
//
///**
// * 91信用卡数据源详细配置
// * 项目名称：credirCardApi
// * 项目版本：V1.0
// * 包名称：com.bankcard.api
// * 创建人：yuqy
// * 创建时间：2017/2/19 15:40
// * 修改人：yuqy
// * 修改时间：2017/2/19 15:40
// * 修改备注：
// */
//@Configuration
//@EnableTransactionManagement
//@EnableJpaRepositories(
//        entityManagerFactoryRef = "entityManagerFactorySecond",//实体管理引用
//        transactionManagerRef = "transactionManagerSecond",//失误管理引用
//        basePackages = {"com.xzm"}) //设置用户数据源所应用到的包
//public class SecondDataSourceConfigurer {
//    //注入用户数据源
//    @Autowired
//    @Qualifier("secondDataSource")
//    private DataSource secondDataSource;
//
//    //配置EntityManager实体
//    @Bean(name = "entityManagerSecond")
//    public EntityManager entityManager(EntityManagerFactoryBuilder builder) {
//        return entityManagerFactorySecond(builder).getObject().createEntityManager();
//    }
//
//    //配置EntityManager工厂实体
//    @Bean(name = "entityManagerFactorySecond")
//    public LocalContainerEntityManagerFactoryBean entityManagerFactorySecond(EntityManagerFactoryBuilder builder) {
//        return builder
//                .dataSource(secondDataSource)
//                .properties(getVendorProperties(secondDataSource))
//                .packages("com.xzm.xzm.pojo") //设置应用creditDataSource的基础包名
//                .persistenceUnit("userPersistenceUnit")
//                .build();
//    }
//
//    //注入jpa配置实体
//    @Autowired
//    private JpaProperties jpaProperties;
//
//    //获取jpa配置信息
//    private Map<String, String> getVendorProperties(DataSource dataSource) {
//        return jpaProperties.getHibernateProperties(dataSource);
//    }
//
//    //配置事务
//    @Bean(name = "transactionManagerSecond")
//    public PlatformTransactionManager transactionManagerSecond(EntityManagerFactoryBuilder builder) {
//        return new JpaTransactionManager(entityManagerFactorySecond(builder).getObject());
//    }
//}
