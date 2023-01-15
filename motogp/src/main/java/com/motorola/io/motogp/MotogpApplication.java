package com.motorola.io.motogp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.motorola.io.motogp")
@EntityScan(basePackages = {"com.motorola.io.motogp","com.motorola.io.motogp.entities.collection"})
//@OpenAPIDefinition(info = @Info(title = "Employees API", version = "2.0", description = "Employees Information"))
public class MotogpApplication {

	public static void main(String[] args) {
		SpringApplication.run(MotogpApplication.class, args);
	}

}
