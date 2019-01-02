package com.xzm.tyb.config;

import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import com.xzm.common.interceptor.SessionInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * ========================
 * addMapping：配置可以被跨域的路径，可以任意配置，可以具体到直接请求路径。
 * allowedMethods：允许所有的请求方法访问该跨域资源服务器，如：POST、GET、PUT、DELETE等。
 * allowedOrigins：允许所有的请求域名访问我们的跨域资源，可以固定单条或者多条内容，
 * 如："http://www.baidu.com"，只有百度可以访问我们的跨域资源。
 * allowedHeaders：允许所有的请求header访问，可以自定义设置任意请求头信息，
 * <p>
 * 作者：恒宇少年
 * 链接：https://www.jianshu.com/p/c6ea21b64f6e
 * 來源：简书
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
@Configuration
public class WebConfiguration extends WebMvcConfigurerAdapter {
    /**
     * 允许跨域
     */
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
//                .allowedMethods("*")
                .allowedOrigins("*")
                .allowedMethods("GET", "POST");
//                .allowedHeaders("*");
    }

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

        /**
         * 修复继承WebMvcConfigurationSupport之后，
         * 静态文件映射会出现问题，需要重新指定静态资源
         */
        registry.addResourceHandler("swagger-ui.html")
                .addResourceLocations("classpath:/META-INF/resources/");
        registry.addResourceHandler("/webjars/**")
                .addResourceLocations("classpath:/META-INF/resources/webjars/");
        registry.addResourceHandler("/favicon.ico")
                .addResourceLocations("classpath:/META-INF/resources/favicon.ico");
        super.addResourceHandlers(registry);
    }


    /**
     * fastJson修改自定义消息转换器
     * @param converters 消息转换器列表
     */
    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        //调用父类的配置
        super.configureMessageConverters(converters);
        //创建fastJson消息转换器
        FastJsonHttpMessageConverter fastConverter = new FastJsonHttpMessageConverter();
        //创建配置类
        FastJsonConfig fastJsonConfig = new FastJsonConfig();
        //修改配置返回内容的过滤
        fastJsonConfig.setSerializerFeatures(
                SerializerFeature.DisableCircularReferenceDetect,
                SerializerFeature.WriteMapNullValue,
                SerializerFeature.WriteNullStringAsEmpty
        );
        fastConverter.setFastJsonConfig(fastJsonConfig);
        //处理中文乱码问题
        List<MediaType> fastMediaType = new ArrayList<>();
        fastMediaType.add(MediaType.APPLICATION_JSON_UTF8);
        fastConverter.setSupportedMediaTypes(fastMediaType);
        //将fastjson添加到视图消息转换器列表内
        converters.add(fastConverter);
    }


    /**
     * 添加自定义拦截器
     * @param registry
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new SessionInterceptor()).addPathPatterns("/**");
//       registry.addInterceptor(new HandshakeInterceptor());
    }

//    @Override
//    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
//        super.configureMessageConverters(converters);
//    }
}
