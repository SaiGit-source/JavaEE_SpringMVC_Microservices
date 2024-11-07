package com.springdatajpa.MongoDBExample.service;

import java.util.List;

import com.springdatajpa.MongoDBExample.dto.CustomerDTO;
import com.springdatajpa.MongoDBExample.model.Customer;

public interface CustomerInterface {
	
	public String registerCustomer(CustomerDTO dto);
	public List<Customer> findAllCustomers();
	public String removeDocument(String id);

}
