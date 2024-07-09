package net.javaguides.organizationservice;

import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@OpenAPIDefinition(
		info = @Info(
				title = "Organization Service REST APIs",
				description = "Organization Service REST APIs Documentation",
				contact = @Contact(
						name="Munirathnam",
						email = "Muni001@gmail.com",
						url = "https://www.javaguides.com"

				),
				license = @License(
						name = "Apache 2.0",
						url="javaguides.net/license"
				)
		),
		externalDocs = @ExternalDocumentation(
				description = "Organizations Service Doc",
				url = "javaguides.net/Organization_Service.html"
)

)
@SpringBootApplication
public class OrganizationServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(OrganizationServiceApplication.class, args);
	}

}
