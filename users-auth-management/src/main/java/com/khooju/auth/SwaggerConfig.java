package com.khooju.auth;

import java.util.function.Predicate;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import static springfox.documentation.builders.PathSelectors.regex;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
	@Bean
	public Docket postsApi() {
		return new Docket(DocumentationType.SWAGGER_2).groupName("public-api")
				.apiInfo(apiInfo()).select().paths(regex("/api.*")).build();
	}



	private ApiInfo apiInfo() {
		return new ApiInfoBuilder().title("Khooju API Documentation")
				.description("Khooju API reference for developers")
				.termsOfServiceUrl("http://khooju.com")
				.contact("mukesh2141990@gmail.com").license("Khoooju License")
				.licenseUrl("mukesh2141990@gmail.com").version("1.0").build();
	}

}
