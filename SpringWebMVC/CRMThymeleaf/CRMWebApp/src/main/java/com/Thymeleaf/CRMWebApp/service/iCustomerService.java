package com.Thymeleaf.CRMWebApp.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.Thymeleaf.CRMWebApp.model.Customer;


@Service
public interface iCustomerService {

	public List<Customer> getCustomerInfo(); // getCustomerInfo list
	public void registerCustomer(Customer customer); // post
	public Customer fetchCxbyId(Integer cid); // update
	public void deleteCustomer(Integer cid); // delete

}
