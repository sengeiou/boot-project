//package com.xzm.modules.tyb.config;
//
//import org.springframework.context.annotation.Configuration;
//import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
//
//@Configuration
//public class MyWebAppConfig extends WebMvcConfigurerAdapter {
//    @Override
//    public void addResourceHandlers(ResourceHandlerRegistry registry) {
//        registry.addResourceHandler("/images/**")
//                .addResourceLocations("classpath:/static/app/images");
//        super.addResourceHandlers(registry);
//    }
//
////    @Description: 对文件的路径进行配置,创建一个虚拟路径/Path/** ，即只要在<img src="/Path/picName.jpg" />便可以直接引用图片
////     *这是图片的物理路径  "file:/+本地图片的地址"
////     * @Date： Create in 14:08 2017/12/20
////     */     registry.addResourceHandler("/Path/**").addResourceLocations("file:/E:/WebPackage/IdeaProjects/shiroLearn/src/main/resources/static/");
////        super.addResourceHandlers(registry);
////}
//}
