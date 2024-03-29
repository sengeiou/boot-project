package com.xzm.single;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.socket.config.annotation.EnableWebSocket;


/**
 * 直白的说Component包含了Configuration的所用注解：
 * Configuration和Component都是注解在类上的，
 * Configuration类中的方法成员变量是@Value注解，方法上的注解是@Bean
 * Component类中的方法和成员变量没有任何限制
 */

//@ImportResource({"classpath:spring.xml"}) 可以代替传统的xml配置

@EnableScheduling//开启定时任务
// mapper 接口类扫描包配置
//@MapperScan(basePackages = {"com.xzm.modules.sys.dao","com.xzm.modules.tyb.dao"})
//@Import({DynamicDataSourceConfig.class})
//@EnableJpaRepositories(basePackages="com.xzm", entityManagerFactoryRef="emf")
//@EnableJpaRepositories(repositoryBaseClass = JpaRepositoryFactoryBean.class)
//@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class,
//        HibernateJpaAutoConfiguration.class})
@ComponentScan(basePackages = "com.xzm.single")
@SpringBootApplication
//@SpringBootApplication(scanBasePackages = "com.xzm")
public class SingletApplication {
    public static void main(String[] args) {
        SpringApplication.run(SingletApplication.class, args);
//		SpringApplication newRun= new SpringApplication(SpringApplication.class);
//		newRun.setBannerMode(Banner.Mode.OFF);
//		newRun.run(args);
    }
}
