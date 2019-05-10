package com.fabio.api.credit.controller;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class CreditControllerApplication {

	public static void main(String[] args) {
		SpringApplication.run(CreditControllerApplication.class, args);
	}

}
