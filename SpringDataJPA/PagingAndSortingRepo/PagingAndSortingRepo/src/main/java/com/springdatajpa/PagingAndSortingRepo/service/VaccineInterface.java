package com.springdatajpa.PagingAndSortingRepo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.springdatajpa.PagingAndSortingRepo.model.Vaccine;

@Service
public interface VaccineInterface {
	
	public Integer countRecords(List<Vaccine> records);

    public Iterable<Vaccine> fetchDetailsBySorting(boolean status, String... properties);
    
    public List<Vaccine> fetchDetailsByPagination(int pgNo, int pgSize,boolean status, String... properties);
    public void fetchDetailsByPagination(int numRec, int pageSize);
}
