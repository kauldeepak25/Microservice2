package com.edureka.springeurekaclientshoppingservice.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
public class ShoppingServiceController {
	@Autowired
	RestTemplate restTemplate;

	@RequestMapping(value = "/getShoppingDetails/{itemname}", method = RequestMethod.GET)
	@HystrixCommand(fallbackMethod = "callRestaurantServiceAndGetData_Fallback")
	public String getStudents(@PathVariable String itemname) {
		System.out.println("Getting School details for " + itemname);
		String response = restTemplate.exchange("http://customer-service/getCustomerDetailsForItem/{itemname}", HttpMethod.GET, null, new ParameterizedTypeReference<String>() {
		}, itemname).getBody();

		System.out.println("Response Received as " + response);
		return "NORMAL FLOW !!! - Item Name -  " + itemname + " \n customer Details " + response;
	}

	@Bean
	@LoadBalanced
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}
	
	@SuppressWarnings("unused")
	private String callRestaurantServiceAndGetData_Fallback(String restaurantName) {
		System.out.println("Restaurant Service is down!!! fallback route enabled...");
		return "CIRCUIT BREAKER ENABLED!!!No Response From Restaurant Service at this moment. Service will be back shortly - " + new Date();
	}
}
