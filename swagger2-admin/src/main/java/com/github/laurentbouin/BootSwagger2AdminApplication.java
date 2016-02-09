package com.github.laurentbouin;

import de.codecentric.boot.admin.config.EnableAdminServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableAdminServer
@EnableAutoConfiguration
@EnableSwagger2
@Configuration
public class BootSwagger2AdminApplication {

	public static void main(String[] args) {
		SpringApplication.run(BootSwagger2AdminApplication.class, args);
	}

	//---- Make a live template of this

   @Bean
   public Docket api() {
       return new Docket(DocumentationType.SWAGGER_2)
         .select()
         .paths(PathSelectors.any())
         .build()
         .apiInfo(apiInfo());
   }

    private ApiInfo apiInfo() {
        ApiInfo apiInfo = new ApiInfo(
         "My REST API",
         "Some custom description of API.",
         "v1.0.0",
         "Terms of service",
         "myeaddress@company.com",
         "License of API",
         "API license URL");
       return apiInfo;
   }

   //----------------------------------
}
