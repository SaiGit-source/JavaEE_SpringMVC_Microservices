package com.Thymeleaf.CRMWebApp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Thymeleaf.CRMWebApp.model.Customer;
import com.Thymeleaf.CRMWebApp.repo.iCustomerRepo;

@Service
public class CustomerService implements iCustomerService {

	@Autowired
	private iCustomerRepo repo;
	
	@Override
	public List<Customer> getCustomerInfo() {
		return (List<Customer>) repo.findAll();
	}

	@Override
	public void registerCustomer(Customer customer) {
		repo.save(customer);
	}

	@Override
	public Customer fetchCxbyId(Integer cid) {
		Optional<Customer> customer = repo.findById(cid);
		return customer.get();
	}

	@Override
	public void deleteCustomer(Integer cid) {
		repo.deleteById(cid);
	}

}
