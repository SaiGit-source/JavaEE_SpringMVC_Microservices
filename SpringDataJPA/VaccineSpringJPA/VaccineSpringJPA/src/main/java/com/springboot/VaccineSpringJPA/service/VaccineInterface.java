package com.springboot.VaccineSpringJPA.service;

import org.springframework.stereotype.Repository;

import com.springboot.VaccineSpringJPA.model.Vaccine;

@Repository
public interface VaccineInterface {
	public String registerVaccineInfo(Vaccine vaccine);
	public Iterable<Vaccine> registerMultipleVaccines(Iterable<Vaccine> vaccines); // send a collection in
	public long getCountVaccines();
	public Iterable<Vaccine> getAllVaccineInfo();
	public Boolean checkVacAvailability(Integer id);
}
