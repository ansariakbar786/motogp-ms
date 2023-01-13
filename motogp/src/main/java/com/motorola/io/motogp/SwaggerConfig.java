package com.motorola.io.motogp;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;

@Configuration
public class SwaggerConfig {

	 @Bean
		public OpenAPI openApi() {
			return new OpenAPI().info(new Info().title("Employee WebApps").description("Employee Details  API").version("v1.0")
					.contact(new Contact().name("Akbar").url("https://asbnotebook.com").email("ansariakbar786@gamil.com"))
					.termsOfService("TOC").license(new License().name("License").url("http://localhost:8283")));
		}
}
