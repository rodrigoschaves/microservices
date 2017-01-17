package com.rodrigoschaves.services.transaction;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan
@EnableEurekaClient
public class TransactionWebservicesApplication {

	public static void main(String[] args) {
		SpringApplication.run(TransactionWebservicesApplication.class, args);
	}
}
