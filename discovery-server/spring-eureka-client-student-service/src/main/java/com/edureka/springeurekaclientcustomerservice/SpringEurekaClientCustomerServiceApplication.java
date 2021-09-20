package com.edureka.springeurekaclientcustomerservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class SpringEurekaClientCustomerServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringEurekaClientCustomerServiceApplication.class, args);
	}
}
