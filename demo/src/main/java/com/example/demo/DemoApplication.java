package com.example.demo;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication {
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
		
		/*
		 * in pom.xml, comment out the spring-boot-starter-data-jpa dependency
		 * until you are ready to connect to a DB
		 */
		
	}
	
	

}
