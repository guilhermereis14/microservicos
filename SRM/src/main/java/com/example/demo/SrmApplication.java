package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.context.config.annotation.RefreshScope;

@RefreshScope
@SpringBootApplication
public class SrmApplication {

	public static void main(String[] args) {
		SpringApplication.run(SrmApplication.class, args);
	}

}
