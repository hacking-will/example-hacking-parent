package com.example.hacking.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

/**
 * Swagger测试接口基础配置
 *
 * @author jintingying
 * Created on 2019/10/11
 * @version 1.0
 */
@Component
public class Swagger {

    @Value("${project.version}")
    private String version;

    @Bean
    public Docket SwagerAPI(){
        return  new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                //此包路径下的类，才生成接口文档
                .apis(RequestHandlerSelectors.basePackage("com.example.hacking.modules"))
                .paths(PathSelectors.any())
                .build();
    }

    /**
     * api文档的详细信息函数
     *
     * @return ApiInfo
     */
    private ApiInfo apiInfo(){
        return new ApiInfoBuilder()
                //大标题
                .title("接口文档")
                //描述
                .description("===接口文档===")
                // 版本号
                .version(version)
                // 作者
                .contact(new Contact("name", "url", "email"))
                //许可证
                .license("license")
                //许可证地址
                .licenseUrl("licenseUrl")
                .build();
    }
}
