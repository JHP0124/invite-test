package io.playdata.util;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.annotations.ApiIgnore;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
	
	@Bean
	public Docket SwaggerApi() {
		
        return new Docket(DocumentationType.SWAGGER_2).ignoredParameterTypes(ApiIgnore.class)
        		.apiInfo(swaggerInfo()).select()
                .apis(RequestHandlerSelectors.basePackage("io.playdata.controller"))
                .build()
                .useDefaultResponseMessages(false);
	}
	
    private ApiInfo swaggerInfo() {
        return new ApiInfoBuilder().title("API Doc 입니다")
                .description("Swagger Doc 학습을 위한 기본 문서 작성 test ")
                .license("license : playdata").licenseUrl("http://www.google.com")
                .version("1").build();
    }
	
	
}
