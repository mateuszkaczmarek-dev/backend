package com.example.java_app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@SpringBootApplication
public class JavaAppApplication extends SpringBootServletInitializer{

	public static void main(String[] args) {
		SpringApplication.run(JavaAppApplication.class, args);
	}

}
