package com.Springboot.JPARepository.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import com.Springboot.JPARepository.model.Vaccine;
import com.Springboot.JPARepository.repo.VaccineInterfaceRepo;

@Service
public class VaccineService implements VaccineInterface {
	
	VaccineInterfaceRepo repo;
	
	@Autowired
	public void setRepo(VaccineInterfaceRepo repo) {
		this.repo = repo;
	}

	@Override
	public Vaccine searchVaccineById(Integer id) {
		
		return repo.getReferenceById(id);
	}

	@Override
	public List<Vaccine> searchVaccineByGivenInfo(Vaccine vac) {
		
		Example<Vaccine> example = Example.of(vac);
		return repo.findAll(example);
	}

	@Override
	public String removeVaccineInfoByIds(Iterable<Integer> ids) {
		
		List<Vaccine> listRecordsbyIds = repo.findAllById(ids);
		List<Vaccine> lstAllRecords = repo.findAll();
		
		if (listRecordsbyIds.size()==lstAllRecords.size()) {
			repo.deleteAllByIdInBatch(ids);
			return "All records deleted by Id";
		}
		return "Unable to delete records";
	}

}
