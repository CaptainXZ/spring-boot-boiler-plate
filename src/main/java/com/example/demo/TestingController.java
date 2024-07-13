package com.example.demo;

import org.springframework.web.bind.annotation.RestController;
import ch.qos.logback.classic.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
@RestController
public class TestingController {
	Logger logger = (Logger) LoggerFactory.getLogger(TestingController.class);

	@GetMapping("/test")
	public String test() {
		logger.info("is this working?");
		return "Test";
	}
}
