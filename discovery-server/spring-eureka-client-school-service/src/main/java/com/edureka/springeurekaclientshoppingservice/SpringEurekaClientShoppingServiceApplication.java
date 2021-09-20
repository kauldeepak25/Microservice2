package com.edureka.springeurekaclientshoppingservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class SpringEurekaClientShoppingServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringEurekaClientShoppingServiceApplication.class, args);
	}
}
