package com.springboot.VaccineSpringJPA.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.VaccineSpringJPA.model.Vaccine;
import com.springboot.VaccineSpringJPA.repo.VaccineInterfaceRepo;

@Service
public class VaccineService implements VaccineInterface {
	
	private VaccineInterfaceRepo repo;	 // note this comes from repo
	
	@Autowired
	public void setRepo(VaccineInterfaceRepo repo)
	{
		this.repo = repo;
	}


	@Override
	public String registerVaccineInfo(Vaccine vaccine) {
		Vaccine retVac = repo.save(vaccine);
		return "Vaccine "+retVac.getId()+" registered";
	}

	@Override
	public Iterable<Vaccine> registerMultipleVaccines(Iterable<Vaccine> vaccines) {
		Iterable<Vaccine> retVac = repo.saveAll(vaccines);
		return retVac;
	}

	@Override
	public long getCountVaccines() {
		return repo.count();
	}

	@Override
	public Iterable<Vaccine> getAllVaccineInfo() {
		
		return repo.findAll();
	}

	@Override
	public Boolean checkVacAvailability(Integer id) {
		
		return repo.existsById(id);
	}

}
