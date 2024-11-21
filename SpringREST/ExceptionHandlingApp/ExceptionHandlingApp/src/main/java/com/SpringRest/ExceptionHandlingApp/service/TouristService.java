package com.SpringRest.ExceptionHandlingApp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.SpringRest.ExceptionHandlingApp.exception.TouristNotFoundException;
import com.SpringRest.ExceptionHandlingApp.model.Tourist;
import com.SpringRest.ExceptionHandlingApp.repo.iTouristRepo;

@Service
public class TouristService implements iTouristService {

	@Autowired
	private iTouristRepo repo;
	
	@Override
	public List<Tourist> fetchAllTourists() {
		return repo.findAll();
	}

	@Override
	public Tourist fetchTouristById(Integer tid) throws TouristNotFoundException {
		return repo.findById(tid).orElseThrow(()-> new TouristNotFoundException("Custom Exception: Tourist ID not found in database"));
	}

	@Override
	public String registerTourist(Tourist tourist) {
		Tourist tObj = repo.save(tourist);
		return "Tourist with ID: "+tObj.getTid()+" registered in database";
	}

}
