package com.Thymeleaf.ThymeleafCSS.service;

import java.util.List;

import com.Thymeleaf.ThymeleafCSS.model.Customer;
import com.Thymeleaf.ThymeleafCSS.repo.iCustomerRepo;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
