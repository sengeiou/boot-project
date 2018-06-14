package com.xzm.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * ========================
 * Created with IntelliJ IDEA.
 * TestUser：恒宇少年
 * Date：2017/4/11
 * Time：20:55
 * 码云：http://git.oschina.net/jnyqy
 * ========================
 */
@Configuration
public class Chapter9Configuration extends WebMvcConfigurerAdapter
{
    //自定义静态资源文件路径
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/com/xzm/resources/**")
                .addResourceLocations("classpath:/static/");
//        registry.addResourceHandler("/images/**")
//                .addResourceLocations("classpath:/static/app/images");
//        registry.addResourceHandler("/src/main/webapp/**")
//                .addResourceLocations("classpath:/webapp/");
        //@Description: 对文件的路径进行配置,创建一个虚拟路径/Path/** ，
        // 即只要在<img src="/Path/picName.jpg" />便可以直接引用图片
//        registry.addResourceHandler("/Path/**")
//                .addResourceLocations("file:/E:/WebPackage/IdeaProjects/shiroLearn/src/main/resources/static/");
    }
}
