package com.springdatajpa.CustomFinder.service;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springdatajpa.CustomFinder.model.Vaccine;
import com.springdatajpa.CustomFinder.repo.VacInterfaceRepo;

@Service
public class VaccineService implements VaccineInterface {
	
	VacInterfaceRepo repo;
	
	@Autowired
	public void setRepo(VacInterfaceRepo repo) {
		this.repo = repo;
	}

	@Override
	public List<Vaccine> fetchByPrice(Double price) {
		return  repo.findByPrice(price);
	}

	@Override
	public List<Vaccine> fetchByPriceLessThanEqual(Double price) {
		return repo.findByPriceLessThanEqual(price);
	}

	@Override
	public List<Vaccine> fetchByPriceBetween(Double startPrice, Double endPrice) {
		return repo.findByPriceBetween(startPrice, endPrice);
	}

	@Override
	public List<Vaccine> fetchByVaccineCompanyEquals(String name) {
		return repo.findByManufacturerEquals(name);
	}

	@Override
	public List<Vaccine> fetchByVaccineNameInAndCostBetween(Collection<String> names, Double minPrice,
			Double maxPrice) {
		return repo.findByVaccineNameInAndPriceBetween(names, minPrice, maxPrice);
	}
	
	
	
	

}
