package com.springdatajpa.CustomQuery.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springdatajpa.CustomQuery.model.Vaccine;
import com.springdatajpa.CustomQuery.repo.VacInterfaceRepo;

@Service
public class VaccineService implements VaccineInterface {
	
	VacInterfaceRepo repo;
	
	@Autowired
	public void setRepo(VacInterfaceRepo repo) {
		this.repo = repo;
	}

	@Override
	public List<Vaccine> fetchByVaccineCompany(String companyName) {
		return repo.searchByManufacturer(companyName);
	}

	@Override
	public List<Vaccine> fetchByVaccineCompany(String comp1, String comp2) {
		return repo.searchByManufacturer(comp1, comp2);
	}

	@Override
	public List<String> fetchVaccinesByCost(Double startRange, Double maxRange) {
		return repo.searchVaccinesByPrice(startRange, maxRange);
	}

	@Override
	public int updateThePriceByVaccineName(Double newPrice, String vaccineName) {
		return repo.updatePriceByVaccineName(newPrice, vaccineName);
	}

	@Override
	public int deleteTheVaccinesByvaccineNames(String vaccineName) {
		return repo.deleteVaccinesByvaccineNames(vaccineName);
	}

	@Override
	public int insertVaccineDetails(Integer id, String vaccineName, String vaccineCompany, Double cost) {
		return repo.insertVaccineRecord(id, vaccineName, vaccineCompany, cost);
	}

	@Override
	public Date getSystemDateAndTime() {
		return repo.getRepoSystemDateAndTime();
	}

}
