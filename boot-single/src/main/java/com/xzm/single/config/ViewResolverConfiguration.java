//package com.xzm.config;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.web.servlet.view.InternalResourceViewResolver;
//import org.springframework.web.servlet.view.JstlView;
//import org.thymeleaf.spring4.SpringTemplateEngine;
//import org.thymeleaf.spring4.templateresolver.SpringResourceTemplateResolver;
//import org.thymeleaf.spring4.view.ThymeleafView;
//import org.thymeleaf.spring4.view.ThymeleafViewResolver;
//import org.thymeleaf.templateresolver.ITemplateResolver;
//
//@Configuration
//public class ViewResolverConfiguration {
//
//    @Bean
//    public InternalResourceViewResolver getJspViewResolver(){
//        InternalResourceViewResolver jspViewResolver=new InternalResourceViewResolver();
//        jspViewResolver.setPrefix("/WEB-INF/");
//        jspViewResolver.setSuffix(".jsp");
//        jspViewResolver.setViewClass(JstlView.class);
////通过ViewNames属性来实现，通过请求中返回的视图名称匹配其采用哪个对应的视图解析器处理，从而找到对应prefix下的页面
//        jspViewResolver.setViewNames("jsp/*");
//        jspViewResolver.setOrder(10);
////开发时不启用缓存，改动即可生效
//        jspViewResolver.setCache(false);
//        return jspViewResolver;
//    }
////    @Bean
////    public ITemplateResolver templateResolver(){
////        ITemplateResolver templateResolver=new ServletContextTemplateResolver();
////        templateResolver.settp("/WEB-INF/templates/");
////        templateResolver.setSuffix(".html");
////        templateResolver.setTemplateMode("HTML5");
////        templateResolver.setOrder(0);
////        templateResolver.setCacheable(false);
////        templateResolver.setCharacterEncoding("UTF-8");
////        return templateResolver;
////    }
//        @Bean
//    public ITemplateResolver templateResolver() {
//        SpringResourceTemplateResolver templateResolver = new SpringResourceTemplateResolver();
//        templateResolver.setTemplateMode("HTML5");
////        templateResolver.setPrefix("/WEB-INF/");
//        templateResolver.setPrefix("classpath:/templates/");
//        templateResolver.setSuffix(".html");
//        templateResolver.setCharacterEncoding("utf-8");
//        templateResolver.setCacheable(false);
//        return templateResolver;
//    }
//    @Bean
//    public SpringTemplateEngine
//    templateEngine(){
//        SpringTemplateEngine templateEngine=new SpringTemplateEngine();
//        templateEngine.setTemplateResolver(templateResolver());
//        return templateEngine;
//    }
//    @Bean
//    public ThymeleafViewResolver thymeleafViewResolver(){
//        ThymeleafViewResolver thymeleafViewResolver=new ThymeleafViewResolver();
//        thymeleafViewResolver.setTemplateEngine(templateEngine());
//        thymeleafViewResolver.setViewClass(ThymeleafView.class);
//        thymeleafViewResolver.setViewNames(new String[]{"thymeleaf/*"});
//        thymeleafViewResolver.setCharacterEncoding("UTF-8");
////开发时不启用缓存，改动即可生效
//        thymeleafViewResolver.setCache(false);
//        return thymeleafViewResolver;
//    }
//}
