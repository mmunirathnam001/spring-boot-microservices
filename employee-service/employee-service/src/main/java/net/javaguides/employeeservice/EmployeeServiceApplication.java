package net.javaguides.employeeservice;

import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.reactive.function.client.WebClientAutoConfiguration;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

@SpringBootApplication
@EnableFeignClients
@OpenAPIDefinition(
		info = @Info(
				title = "Employee Service REST APIs",
				description = "Employee Service REST APIs documentations",
				contact = @Contact(
						name = "Muni",
						email = "Muni001@gmail.com",
						url = "javaguides.net"
				),
				license = @License(
						name = "Apache 2.0",
						url = "javaguides.net/license"
				)

		),
		externalDocs = @ExternalDocumentation(
				description = "Employee Service Doc",
				url = "javaguides.net/employee_service.html"
		)
)
public class EmployeeServiceApplication {
	@Bean
	public WebClient webClient(){
		return WebClient.builder().build();
	}
/*	@Bean
	public RestTemplate restTemplate(){

		return new RestTemplate();
	}*/


	public static void main(String[] args) {

		SpringApplication.run(EmployeeServiceApplication.class, args);
	}

}
