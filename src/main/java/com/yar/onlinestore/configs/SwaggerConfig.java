package com.yar.onlinestore.configs;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.StringVendorExtension;
import springfox.documentation.service.VendorExtension;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collection;
import java.util.HashSet;

import static springfox.documentation.builders.PathSelectors.regex;

@Configuration
@EnableSwagger2
@Profile("dev")
public class SwaggerConfig {

    @Value("${spring.application.name}")
    private String projectName;

    @Value("${spring.application.description}")
    private String projectDescription;

    @Value("${project.release.version}")
    private String projectVersion;

    @SuppressWarnings("HardcodedFileSeparator")
    @Bean
    public Docket productApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.yar.onlinestore.controller"))
                .paths(regex("/*"))
                .build()
                .apiInfo(metaData());
    }

    private ApiInfo metaData() {
        Collection<VendorExtension> vendorExtensions = new HashSet<>();
        vendorExtensions.add(new StringVendorExtension("onlinestore", "RemoteCardLoading"));
        return new ApiInfo(
                projectName,
                projectDescription,
                projectVersion,
                "Terms of service",
                new Contact("Ehsan Yar", "https://www.onlinestore.com", "ehsanyar2012@gmail.com"),
                "Apache License Version 2.0",
                "https://www.apache.org/licenses/LICENSE-2.0",
                vendorExtensions);
    }

}