package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.example.demo.repository")
@EntityScan(basePackages = "com.example.demo.models")
public class DemoApplication {
	// log 
	// 1. info
	// 2. debug
	// 3. error
	// 4. warn
	// 5. trace
	// 6. fatal
	// 7. off
	// 8. all
	
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

}
