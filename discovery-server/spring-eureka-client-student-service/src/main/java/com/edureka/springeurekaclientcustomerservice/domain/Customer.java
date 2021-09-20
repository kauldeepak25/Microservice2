package com.edureka.springeurekaclientcustomerservice.domain;

public class Customer {
	private String name;
	private String custAddress;
	/**
	 * @param name
	 * @param custAddress
	 */
	public Customer(String name, String custAddress) {
		super();
		this.name = name;
		this.custAddress = custAddress;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCustAddress() {
		return custAddress;
	}
	public void setCustAddress(String custAddress) {
		this.custAddress = custAddress;
	}

	
	
}
