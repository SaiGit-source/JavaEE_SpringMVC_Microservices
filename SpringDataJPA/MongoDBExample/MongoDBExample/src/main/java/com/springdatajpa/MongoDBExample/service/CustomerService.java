package com.springdatajpa.MongoDBExample.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springdatajpa.MongoDBExample.dto.CustomerDTO;
import com.springdatajpa.MongoDBExample.model.Customer;
import com.springdatajpa.MongoDBExample.repo.CustInterfaceRepo;

@Service
public class CustomerService implements CustomerInterface{

	/* Constructor injection this also works
	@Autowired
	private CustInterfaceRepo repo;
	but setter injection is recommended
	*/
	
	private CustInterfaceRepo repo;
	
	@Autowired
	public void setRepo(CustInterfaceRepo repo) {
		this.repo=repo;
	}
	
	@Override
	public String registerCustomer(CustomerDTO dto) {
		Customer ct = new Customer();
		BeanUtils.copyProperties(dto, ct);
		Customer status = repo.save(ct);
		return "Customer Info stored with ID: "+ct.getId();
	}

	@Override
	public List<Customer> findAllCustomers() {
		return repo.findAll();
	}

	@Override
	public String removeDocument(String id) {
		Optional<Customer> optional = repo.findById(id);
		if (optional.isPresent()) 
		{
			repo.deleteById(id);
			return "Document with id: "+id+" is deleted";
			
		}
		return "Document with id: "+id+" not found";
	}

}
