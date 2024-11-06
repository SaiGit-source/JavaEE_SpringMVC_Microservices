package com.Springboot.JPARepository.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Springboot.JPARepository.model.Vaccine;

@Repository
public interface VaccineInterfaceRepo extends JpaRepository<Vaccine, Integer> 
{

}
