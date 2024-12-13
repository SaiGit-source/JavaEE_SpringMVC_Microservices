package com.SpringBoot.MultiDBProj.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.SpringBoot.MultiDBProj.model.customer.Customer;
import com.SpringBoot.MultiDBProj.model.product.Product;
import com.SpringBoot.MultiDBProj.repo.cx.ICustRepo;
import com.SpringBoot.MultiDBProj.repo.pd.IProdRepo;

@Service
public class MultiDbService {
	
	@Autowired
	private ICustRepo mySQLRepo;
	@Autowired
	private IProdRepo postgresRepo;
	
	public List<Customer> getCustomer(){
		return mySQLRepo.findAll();
	}
	
	public List<Product> getProduct(){
		return postgresRepo.findAll();
	}

}
