package com.springdatajpa.CustomFinder.service;

import java.util.Collection;
import java.util.List;

import org.springframework.stereotype.Service;

import com.springdatajpa.CustomFinder.model.Vaccine;

@Service
public interface VaccineInterface {
	
	public List<Vaccine> fetchByPrice(Double price);
	
	public List<Vaccine> fetchByPriceLessThanEqual(Double price);
	
	public List<Vaccine> fetchByPriceBetween(Double startPrice, Double endPrice);
	
	public List<Vaccine> fetchByVaccineCompanyEquals(String name);
	
	public List<Vaccine> fetchByVaccineNameInAndCostBetween(Collection<String> names,Double minPrice, Double maxPrice);


}
