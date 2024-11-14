package com.springmvc.CRMWebApplication.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springmvc.CRMWebApplication.model.Customer;
import com.springmvc.CRMWebApplication.repo.ICustomerRepo;

@Service
public class CustomerService implements ICustomerService {
	
	private ICustomerRepo repo;
	
	@Autowired
	public void setRepo(ICustomerRepo repo) {
		this.repo = repo;
	}

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
		Optional<Customer> cust = repo.findById(cid);
		return cust.get();
	}

	@Override
	public void deleteCustomer(Integer cid) {
		repo.deleteById(cid);
		
	}
	
	

}
