package com.Springboot.JPARepository.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.Springboot.JPARepository.model.Vaccine;

@Service
public interface VaccineInterface {
	
	public Vaccine searchVaccineById(Integer id);
	public List<Vaccine> searchVaccineByGivenInfo(Vaccine vac);
	public String removeVaccineInfoByIds(Iterable<Integer> ids);

}
