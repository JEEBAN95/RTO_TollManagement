package com.jk.SwaggerConfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfigurer {

	@Bean
	public Docket swaggerConfiguration() {
		// returns a prepared Docket instance
		Docket docket = new Docket(DocumentationType.SWAGGER_2)
				// get the Docket builder/ApiSelectorBuilder object
				.select()
				// select the path of the Api
				.paths(PathSelectors.any())
				// specifying the location of Api
				.apis(RequestHandlerSelectors.basePackage("com.jk.restApi")).build().apiInfo(apiDetails());
		return docket;
	}

	@SuppressWarnings("deprecation")
	private ApiInfo apiDetails() {
		return new ApiInfo("RTO Application Api", "Application Dcument", "1.0", "http://<hostName>:2525/rto/",
				"All India RTO Corporation", "Api Licence", "?");
	}
}
