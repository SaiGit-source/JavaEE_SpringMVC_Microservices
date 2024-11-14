package com.springmvc.CRMWebApplication.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.springmvc.CRMWebApplication.model.Customer;

@Service
public interface ICustomerService {

	public List<Customer> getCustomerInfo();
	public void registerCustomer(Customer customer);
	public Customer fetchCxbyId(Integer cid);
	public void deleteCustomer(Integer cid);
	
}
