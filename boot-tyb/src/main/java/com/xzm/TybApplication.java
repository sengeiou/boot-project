package com.xzm;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


/**
 * 直白的说Component包含了Configuration的所用注解：
 * Configuration和Component都是注解在类上的，
 * Configuration类中的方法成员变量是@Value注解，方法上的注解是@Bean
 * Component类中的方法和成员变量没有任何限制
 */
//@tk.mybatis.spring.annotation.MapperScan(basePackages = {"com.xzm.modules.*.dao"}, sqlSessionFactoryRef = "sqlSessionFactoryBean")
//@ImportResource({"classpath:spring.xml"}) 可以代替传统的xml配置
@EnableWebSocket // 允许WebSocketSw
@EnableScheduling//开启定时任务
// mapper 接口类扫描包配置 com.xzm.modules.tyb.dao
//@MapperScan(basePackages = {"com.xzm.modules.tyb.dao",
//        "com.xzm.modules.sys.dao","com.xzm.modules.test.dao"})
//@MapperScan(basePackages = {"com.xzm.modules.*.dao"})
//@Import({DynamicDataSourceConfig.class})
//@EnableJpaRepositories(basePackages="com.xzm", entityManagerFactoryRef="emf")
//@EnableJpaRepositories(repositoryBaseClass = JpaRepositoryFactoryBean.class)
//@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class,
//        HibernateJpaAutoConfiguration.class})
@EnableSwagger2
@SpringBootApplication
public class TybApplication {

    public static void main(String[] args) {
        SpringApplication.run(TybApplication.class, args);

//		SpringApplication newRun= new SpringApplication(SpringApplication.class);
//		newRun.setBannerMode(Banner.Mode.OFF);
//		newRun.run(args);
    }

    //    @Override
//    protected DispatcherServlet createDispatcherServlet(WebApplicationContext servletAppContext) {
//        final DispatcherServlet dispatcherServlet = (DispatcherServlet)
//                super.createDispatcherServlet(servletAppContext);
//        dispatcherServlet.setThrowExceptionIfNoHandlerFound(true);
//        return dispatcherServlet;
//    }
    @Bean
    public static PropertySourcesPlaceholderConfigurer placeholderConfigurer() {
        PropertySourcesPlaceholderConfigurer c = new PropertySourcesPlaceholderConfigurer();
        c.setIgnoreUnresolvablePlaceholders(true);
        return c;
    }
}
