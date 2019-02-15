package com.xzm.tyb.config;

import io.swagger.annotations.Api;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Created by xuzongmeng on 2018/3/2.
 */


/**
 * 用@Configuration注解该类，等价于XML中配置beans；
 * 用@Bean标注方法等价于XML中配置bean。
 *  http://localhost:8002/tyb/swagger-ui.html
 *
 *  http://localhost:8002/tyb/doc.html
 *
 *  http://patorjk.com/software/taag banner生成地址
 *
 *  http://localhost:8002/tyb/swagger-resources
 *  http://localhost:8002/tyb/v2/api-docs?group=groupName
 *  http://localhost:8002/tyb/v2/api-docs-ext?group=groupName
 */
//@Api：修饰整个类，描述Controller的作用
//@ApiOperation：描述一个类的一个方法，或者说一个接口
//@ApiParam：单个参数描述
//@ApiModel：用对象来接收参数
//@ApiProperty：用对象接收参数时，描述对象的一个字段
//@ApiResponse：HTTP响应其中1个描述
//@ApiResponses：HTTP响应整体描述
//@ApiIgnore：使用该注解忽略这个API
//@ApiError ：发生错误返回的信息
//@ApiImplicitParam：一个请求参数
//@ApiImplicitParams：多个请求参数

@EnableSwagger2 //开启Swagger文档
@Configuration
public class Swagger2Config {
    private  boolean enable = true;
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("app接口文档")
                .description("app接口文档")
                .termsOfServiceUrl("www.smallxzm.top")
                .version("1.0")
                .build();
    }
    @Bean
    public Docket tybApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("投油宝APP")
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.xzm.tyb.controller"))
                .paths(PathSelectors.any())
                .build();
    }

    @Bean
    public Docket sysApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("系统模块")
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.xzm.sys.controller"))
                .paths(PathSelectors.any())
                .build();
    }

    @Bean("test")
    public Docket userApis() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("测试模块")
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.xzm.modules.test.controller"))
                .paths(PathSelectors.regex("/test.*"))
                .build()
                .apiInfo(apiInfo())
                .enable(enable);
    }

//    @Bean
//    public Docket system() {
//        return new Docket(DocumentationType.SWAGGER_2)
//                .groupName("系统模块")
//                .select()
//                .apis(RequestHandlerSelectors.withClassAnnotation(Api.class))
//                .paths(PathSelectors.regex("/system.*"))
//                .build()
//                .apiInfo(apiInfo())
//                .enable(enable);
//    }

}
