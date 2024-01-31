package com.minhphuc.hprserverjava.config;

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
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Component
@EnableSwagger2
public class SwaggerConfig {

    @Value("${swagger.enable}")
    private boolean enable;

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("API management system - Hoài Phúc Robotic")
                .description("Trang web quản lý các api")
                .termsOfServiceUrl("https://hoaiphuc.com/")
                .contact(new Contact("IT team", "bull", "minhphuczy@gmail.com"))
                .version("1.0.1")
                .build();
    }

    public Docket createRestApi(String groupName, String basePackage) {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName(groupName)
                .enable(enable)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage(basePackage))
                .paths(PathSelectors.any())
                .build();
    }

    @Bean
    public Docket createSystemApi() {
        return createRestApi("System API", "com.minhphuc.hprserverjava.controller.system");
    }
    @Bean
    public Docket createModelApi() {
        return createRestApi("HR API", "com.minhphuc.hprserverjava.controller.hr");
    }

}