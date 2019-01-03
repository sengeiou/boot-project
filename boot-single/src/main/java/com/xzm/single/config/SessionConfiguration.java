package com.xzm.single.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * ========================
 * Created with IntelliJ IDEA.
 * TestUser：恒宇少年
 * Date：2017/4/7
 * Time：21:47
 * 码云：http://git.oschina.net/jnyqy
 * ========================
 *  implements   WebMvcConfigurer
 */
@Configuration
public class SessionConfiguration extends WebMvcConfigurerAdapter
{
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
//       registry.addInterceptor(new SessionInterceptor()).addPathPatterns("/**");
//       registry.addInterceptor(new HandshakeInterceptor());
    }

//    @Bean
//    public ViewResolver springThymeleafViewResolver() {
//
//            ThymeleafViewResolver viewResolver = new ThymeleafViewResolver();
////            viewResolver.setTemplateEngine(templateEngine());
//            viewResolver.setOrder(1);
//             viewResolver.setCharacterEncoding("utf-8");
//            return viewResolver;
//        }
}
