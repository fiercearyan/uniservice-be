package com.uniservice;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class UniserviceApplication {

	//brew services start mongodb-community@8.0
	//brew services stop mongodb-community@8.0

	public static void main(String[] args) {
		SpringApplication.run(UniserviceApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner() {
		return args -> {
			System.out.println("Swagger UI : "+"http://localhost:8080/swagger-ui.html");
			System.out.println("                        ");
			System.out.println("************************");
			System.out.println("Application has started!");
			System.out.println("************************");
		};
	}
}
