package com.springbootAPI.restfulCRUDapi;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(
		info = @Info(
				title = "RESTFUL-CRUD",
				description = "Basic Springboot API to demonstrate CRUD operations",
				version = "1.0",
				contact = @Contact(
						name = "Deepak Varma",
						email = "varmadeepak3710@gmail.com"
				),
				license = @License(
						name = "Apache 2.0"
				)
		)
)
public class RestfulCrudApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestfulCrudApiApplication.class, args);
	}

}
