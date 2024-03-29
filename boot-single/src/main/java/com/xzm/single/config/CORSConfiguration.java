package com.xzm.single.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * ========================
 *addMapping：配置可以被跨域的路径，可以任意配置，可以具体到直接请求路径。
 * allowedMethods：允许所有的请求方法访问该跨域资源服务器，如：POST、GET、PUT、DELETE等。
 * allowedOrigins：允许所有的请求域名访问我们的跨域资源，可以固定单条或者多条内容，
 * 如："http://www.baidu.com"，只有百度可以访问我们的跨域资源。
 * allowedHeaders：允许所有的请求header访问，可以自定义设置任意请求头信息，
 *
 * 作者：恒宇少年
 * 链接：https://www.jianshu.com/p/c6ea21b64f6e
 * 來源：简书
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
@Configuration
public class CORSConfiguration extends WebMvcConfigurerAdapter
{
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedMethods("*")
                .allowedOrigins("*")
                .allowedHeaders("*");
    }
}
