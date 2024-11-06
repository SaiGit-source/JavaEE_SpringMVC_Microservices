package com.springdatajpa.CustomFinder.repo;

import java.util.Collection;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springdatajpa.CustomFinder.model.Vaccine;
// Custom finder methods

public interface VacInterfaceRepo extends JpaRepository<Vaccine, Integer>
{
	//findBy-PropertyName-keyword
	
	public List<Vaccine> findByPrice(Double price);
//	public List<Vaccine> findByCostIs(Double cost);
//	public List<Vaccine> findByCostEquals(Double cost);
	public List<Vaccine> findByPriceLessThanEqual(Double price);
	public List<Vaccine> findByPriceBetween(Double startPrice, Double endPrice);
	public List<Vaccine> findByManufacturerEquals(String name);
	public List<Vaccine> findByVaccineNameInAndPriceBetween(Collection<String> names,Double minPrice, Double maxPrice);

}
