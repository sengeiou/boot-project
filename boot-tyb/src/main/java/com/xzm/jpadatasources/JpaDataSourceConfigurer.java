//package com.xzm.jpadatasources;
//
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
//import org.springframework.boot.context.properties.ConfigurationProperties;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.Primary;
//
//import javax.sql.DataSource;
//
///**
// * ========================
// * Created with IntelliJ IDEA.
// * User：恒宇少年
// * Date：2017/5/30
// * Time：14:34
// * 码云：http://git.oschina.net/jnyqy
// * ========================
// */
//@Configuration
//public class JpaDataSourceConfigurer {
//
//    //第一个数据源
//    @Bean(name = "firstDataSource")//装配该方法返回值为userDataSource管理bean
//    @Qualifier("firstDataSource")//spring装配bean唯一标识
//    @ConfigurationProperties(prefix = "spring.datasource.first")//application.yml文件内配置数据源的前缀
//    public DataSource firstDataSource() {
//        return DataSourceBuilder.create().build();
//    }
//
//    //第二个据源
//    @Bean(name = "secondDataSource")
//    @Primary//配置该数据源为主数据源
//    @Qualifier("secondDataSource")
//    @ConfigurationProperties(prefix = "spring.datasource.second")
//    public DataSource secondDataSource() {
//        return DataSourceBuilder.create().build();
//    }
//}
