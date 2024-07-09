package net.javaguides.departmentservice;

import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import jdk.jfr.Description;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@OpenAPIDefinition(
		info= @Info(
				title="Department service REST API's",
				description = "Department service REST API's Documentation",
				version = "v1.0",
				contact = @Contact(
						name="M Munirathnam",
						email = "Muni@gmail.com",
						url = "https://www.javaguides.com"
				),
				license =@License(
						name = "Apache 2.0",
						url = "https://www.javaguides.com"
				)

		),
		externalDocs = @ExternalDocumentation(
				description = "Department-service doc",
				url="https://www.javaguides.com"
		)
)

@SpringBootApplication
public class DepartmentServiceApplication  {

	public static void main(String[] args)
	{

		SpringApplication.run(DepartmentServiceApplication.class, args);
	}

}
