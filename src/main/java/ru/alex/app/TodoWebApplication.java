package ru.alex.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class TodoWebApplication {
	@Bean
	public Docket swagger() {
		return new Docket(DocumentationType.SWAGGER_2)
							.apiInfo(getApiInfo())
							.select()
							.apis(RequestHandlerSelectors.any())
							.build();
	}

	private ApiInfo getApiInfo() {
		Contact contact = new Contact("Alex Vasayev", "https://github.com/WoodySide", "https://github.com/WoodySide");
		return new ApiInfoBuilder()
					.title("Todo Web Application")
					.description("Spring Boot Web App with RESTful APIs")
					.version("1.0.0")
					.license("Apache 2.0")
					.licenseUrl("http://www.apache.org/licenses/LICENSE-2.0")
					.contact(contact)
					.build();
	}

	public static void main(String[] args) {
		SpringApplication.run(TodoWebApplication.class, args);
	}

}
