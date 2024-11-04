package com.springdatajpa.PagingAndSortingRepo.repo;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.springdatajpa.PagingAndSortingRepo.model.Vaccine;

@Repository
public interface InterfaceVacRepo extends PagingAndSortingRepository<Vaccine, Integer> 
{
// Vaccine object and Primary key datatype
}
