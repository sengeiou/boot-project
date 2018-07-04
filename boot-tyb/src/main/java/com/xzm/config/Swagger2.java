package com.xzm.config;

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
 *  http://localhost:8080/swagger-ui.html
 *
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

//开启Swagger文档
@Configuration
public class Swagger2 {
    private  boolean enable;
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("api文档")
                .description("app接口文档")
                .termsOfServiceUrl("www.smallxzm.top")
                .version("1.0")
                .build();
    }
    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("投油宝API")
                .apiInfo(apiInfo())
                .select()
//                .apis(RequestHandlerSelectors.basePackage("com.xzm.modules.test.api"))
                .apis(RequestHandlerSelectors.basePackage("com.xzm.modules.tyb.controller"))
                .paths(PathSelectors.any())
                .build();
    }
    @Bean
    public Docket createTestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("测试xxx")
                .apiInfo(apiInfo())
                .select()
//                .apis(RequestHandlerSelectors.basePackage("com.xzm.modules.test.api"))
                .apis(RequestHandlerSelectors.basePackage("com.xzm.modules.test.controller"))
                .paths(PathSelectors.any())
                .build();
    }
    @Bean("test")
    public Docket userApis() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("测试模块")
                .select()
//                .apis(RequestHandlerSelectors.withClassAnnotation(Api.class))
                .apis(RequestHandlerSelectors.basePackage("com.xzm.modules.test.controller"))
                .paths(PathSelectors.regex("/test.*"))
                .build()
                .apiInfo(apiInfo())
                .enable(enable);
    }

    @Bean("system")
    public Docket system() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("系统模块")
                .select()
                .apis(RequestHandlerSelectors.withClassAnnotation(Api.class))
                .paths(PathSelectors.regex("/system.*"))
                .build()
                .apiInfo(apiInfo())
                .enable(enable);
    }

//    @Bean("UserApis")
//    public Docket userApis() {
//        return new Docket(DocumentationType.SWAGGER_2)
//                .groupName("用户模块")
//                .select()
//                .apis(RequestHandlerSelectors.withClassAnnotation(Api.class))
//                .paths(PathSelectors.regex("/user.*"))
//                .build()
//                .apiInfo(apiInfo())
//                .enable(enable);
//    }
//
//    @Bean("CustomApis")
//    public Docket customApis() {
//        return new Docket(DocumentationType.SWAGGER_2)
//                .groupName("客户模块")
//                .select()
//                .apis(RequestHandlerSelectors.withClassAnnotation(Api.class))
//                .paths(PathSelectors.regex("/custom.*"))
//                .build()
//                .apiInfo(apiInfo())
//                .enable(enable);
//    }

//    private ApiInfo apiInfo() {
//        return new ApiInfoBuilder()
//                .title("XXXXX系统平台接口文档")
//                .description("提供子模块1/子模块2/子模块3的文档, 更多请关注公众号: 随行享阅")
//                .termsOfServiceUrl("https://xingtian.github.io/trace.github.io/")
//                .version("1.0")
//                .build();
//    }

}
