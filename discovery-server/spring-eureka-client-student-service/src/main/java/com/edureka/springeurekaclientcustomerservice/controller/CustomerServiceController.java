package com.edureka.springeurekaclientcustomerservice.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.edureka.springeurekaclientcustomerservice.domain.Customer;

@RestController
public class CustomerServiceController {

	private static Map<String, List<Customer>> customerDb = new HashMap<String, List<Customer>>();

	static {
		customerDb = new HashMap<String, List<Customer>>();

		List<Customer> lst = new ArrayList<Customer>();
		Customer std = new Customer("Sajal", "3rd Linkon Drive, New York ");
		lst.add(std);
		std = new Customer("Lokesh", "645, applegove ln, Jersey City");
		lst.add(std);

		customerDb.put("abcitem", lst);

		lst = new ArrayList<Customer>();
		std = new Customer("Kajal", "Changi , Singapore");
		lst.add(std);
		std = new Customer("Sukesh", "baker Street , London");
		lst.add(std);

		customerDb.put("xyzitem", lst);

	}

	@RequestMapping(value = "/getCustomerDetailsForItem/{itemname}", method = RequestMethod.GET)
	public List<Customer> getStudents(@PathVariable String itemname) {
		System.out.println("Getting customer details for " + itemname);

		List<Customer> customerList = customerDb.get(itemname);
		if (customerList == null) {
			customerList = new ArrayList<Customer>();
			Customer std = new Customer("Not Found", "N/A");
			customerList.add(std);
		}
		return customerList;
	}
}
