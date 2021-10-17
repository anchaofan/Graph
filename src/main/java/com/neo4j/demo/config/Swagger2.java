package com.neo4j.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

//开启Swagger2
//配置注解
@EnableSwagger2
@Configuration
public class Swagger2 {
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("旅游知识图谱api文档")//API文档标题
                .description("restful风格")//
                .termsOfServiceUrl("localhost:")
                .version("1.0")
                .build();
    }

    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                //配置API的基本信息（会在http://项目实际地址/swagger-ui.html页面显示）
                //扫描basePackage包下面的“/rest/”路径下的内容作为接口文档构建的目标
                .apis(RequestHandlerSelectors.basePackage("com.neo4j.demo.controller"))
//                .paths(PathSelectors.regex("/rest/.*"))
                .build();
    }
}
