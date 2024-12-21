package org.jsp.product_api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "Product Rest Api",description = "Rest apiusing springboot for performing crud operations",version = "1.4.3",contact = @Contact(url="https://github.com/rakeshkr2002",name = "Rakesh K R",email = "rakeshkr4208@gmail.com")))
public class ProductApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProductApiApplication.class, args);
	}

}
