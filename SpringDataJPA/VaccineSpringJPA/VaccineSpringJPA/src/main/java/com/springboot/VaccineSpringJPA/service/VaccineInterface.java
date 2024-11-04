package com.springboot.VaccineSpringJPA.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.springboot.VaccineSpringJPA.model.Vaccine;

@Repository
public interface VaccineInterface {
	public String registerVaccineInfo(Vaccine vaccine);
	public Iterable<Vaccine> registerMultipleVaccines(Iterable<Vaccine> vaccines); // send a collection in
	public long getCountVaccines();
	public Iterable<Vaccine> getAllVaccineInfo();
	public Boolean checkVacAvailability(Integer id);
	
	public Optional<Vaccine> getVaccineById(Integer id);
	public Iterable<Vaccine> getAllVaccinesByIDs(Iterable<Integer>ids);
	public String removeVaccineById(Integer id);
	public String removeVaccineByVaccineObj(Vaccine obj);
	public String removeAllVaccines(List<Integer>ids);

}
