package com.example.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = { "com.example.controller", "com.example.service", "com.capgemini.dao" })
@EnableJpaRepositories("com.capgemini.dao")
@EntityScan("com.capgemini.entity")
public class OnlineSalonServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(OnlineSalonServiceApplication.class, args);
		System.out.println("server started");
	}

}
