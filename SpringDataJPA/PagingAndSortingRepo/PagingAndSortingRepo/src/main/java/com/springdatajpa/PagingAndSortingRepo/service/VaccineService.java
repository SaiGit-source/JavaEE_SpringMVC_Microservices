package com.springdatajpa.PagingAndSortingRepo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.springdatajpa.PagingAndSortingRepo.model.Vaccine;
import com.springdatajpa.PagingAndSortingRepo.repo.InterfaceVacRepo;

@Service
public class VaccineService implements VaccineInterface {
	
	private InterfaceVacRepo repo;
	
	@Autowired
	public void setRepo(InterfaceVacRepo repo)
	{
		this.repo = repo;
	}

	@Override
	public Iterable<Vaccine> fetchDetailsBySorting(boolean status, String... properties) {
		Sort sort = Sort.by(status?Direction.ASC:Direction.DESC, properties);
		return repo.findAll(sort);
	}

	@Override
	public List<Vaccine> fetchDetailsByPagination(int pgNo, int pgSize, boolean status, String... properties) {
		PageRequest pageable = PageRequest.of(pgNo, pgSize, status?Direction.ASC:Direction.DESC, properties);
		Page<Vaccine> page = repo.findAll(pageable);
		return page.getContent();
	}

	@Override
	public void fetchDetailsByPagination(int numRec, int pageSize) {
		long pagecount = numRec / pageSize;
		
		pagecount = numRec % pageSize==0 ? pagecount : ++pagecount;
		
		for (int page=0; page<pagecount; page++) {
			PageRequest pageable = PageRequest.of(page, pageSize);
			Page<Vaccine> pg = repo.findAll(pageable);
			System.out.println("-------------Page#: " + page);
			pg.getContent().forEach(p->System.out.println(p.getVaccineName() + " "+ p.getManufacturer()));
			System.out.println("----------------------------------------");
		}
		
	}

	@Override
	public Integer countRecords(List<Vaccine> records) {
		return records.size();
	}



}
