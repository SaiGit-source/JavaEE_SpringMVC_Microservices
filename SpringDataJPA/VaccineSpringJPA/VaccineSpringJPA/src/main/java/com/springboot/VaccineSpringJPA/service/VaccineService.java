package com.springboot.VaccineSpringJPA.service;

import java.util.List;
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


	@Override
	public Optional<Vaccine> getVaccineById(Integer id) {
	
		return repo.findById(id);	
		}


	@Override
	public String removeVaccineById(Integer id) {
		
		Boolean status=repo.existsById(id);
		if (status) {
			repo.deleteById(id);
			return "Successfully deleted: "+id;
		}
		return "id: " + id+" is not present to delete"; 
		 
	}


	@Override
	public String removeVaccineByVaccineObj(Vaccine obj) {
		
		Integer id = obj.getId();
		Optional<Vaccine> optional = repo.findById(id);
		if (optional.isPresent()) {
			repo.deleteById(id);
			return "Record with id "+id+" deleted";
		}
		
		return "Record with id "+id+" not available to delete";
	}


	@Override
	public String removeAllVaccines(List<Integer> ids) {
		
		int countDB = (int) repo.count();
		int countIDs = ids.size();
		if (countIDs==countDB) {
			repo.deleteAllById(ids);
			return "deleted all IDS";
		}
		return "couldn't delete all IDS";

	}


	@Override
	public Iterable<Vaccine> getAllVaccinesByIDs(Iterable<Integer> ids) {
		return repo.findAllById(ids);
	}

}
