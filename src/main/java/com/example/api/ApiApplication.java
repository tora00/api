package com.example.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

/**
 * Entry point for the spring application
 * @author Kevin
 *
 */

@SpringBootApplication
public class ApiApplication extends SpringBootServletInitializer {

	
	public static void main(String[] args) {		
		SpringApplication.run(ApiApplication.class, args);
	}

}
