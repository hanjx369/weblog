package com.vker.weblog.web.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2WebMvc;

/**
 * @Author: 寒江雪
 * @Date: 2023-12-21
 * @Description: Knife4j 配置类
 */
@Profile("dev")
@Configuration
@EnableSwagger2WebMvc
public class Knife4jWebConfig {

    @Bean("webApi")
    public Docket createApiDoc() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(buildApiInfo())
                // 分组名称
                .groupName("Weblog 前台接口")
                .select()
                // 这里指定 Controller 扫描包路径
                .apis(RequestHandlerSelectors.basePackage("com.vker.weblog.web.controller"))
                .paths(PathSelectors.any())
                .build();
    }

    /**
     * 构建 API 信息
     *
     * @return
     */
    private ApiInfo buildApiInfo() {
        return new ApiInfoBuilder()
                .title("Weblog 前台接口文档") // 标题
                .description("Weblog 是一款由 Spring Boot + Vue  + Vite  开发的前后端分离博客。") // 描述
                .termsOfServiceUrl("") // API 服务条款
                .contact(new Contact("Vker", "https://github.com/vkerc", "krismile_code@163.com")) // 联系人
                .version("0.0.1-SNAPSHOT") // 版本号
                .build();
    }

}
