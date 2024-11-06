package com.springdatajpa.JPARepoView.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springdatajpa.JPARepoView.repo.VacInterfaceRepo;
import com.springdatajpa.JPARepoView.view.View;

@Service
public class VaccineService implements VaccineInterface {
	public VacInterfaceRepo repo;
	
	@Autowired
	public void setRepo(VacInterfaceRepo repo) {
		this.repo = repo;
	}

	@Override
	public <T extends View> List<T> fetchByCostLessThan(Double price, Class<T> cls) 
	{	
		return repo.findByCostLessThan(price, cls); // custom search list items with cost less than given cost
	}
	
	
}
