package com.example.java_app;



import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;




@SpringBootApplication
public class JavaAppApplication extends SpringBootServletInitializer{

	public static void main(String[] args) {
		SpringApplication.run(JavaAppApplication.class, args);
	}

}
