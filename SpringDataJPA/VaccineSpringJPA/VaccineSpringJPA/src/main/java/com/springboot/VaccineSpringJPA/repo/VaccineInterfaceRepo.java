package com.springboot.VaccineSpringJPA.repo;

import org.springframework.data.repository.CrudRepository;

import com.springboot.VaccineSpringJPA.model.Vaccine;

public interface VaccineInterfaceRepo extends CrudRepository<Vaccine, Integer> {

}
