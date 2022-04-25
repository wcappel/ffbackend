package com.wcappel.ffbackend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController @SpringBootApplication public class FfbackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(FfbackendApplication.class, args);
	}

}
