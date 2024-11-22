package com.SpringRest.ExceptionHandlingApp.service;

import java.util.List;
import java.util.Optional;

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

	@Override
	public String updateTouristInfo(Tourist tourist) throws TouristNotFoundException {
		Optional<Tourist> optional = repo.findById(tourist.getTid());
			if (optional.isPresent()) {
				repo.save(tourist);
				return "Tourist with ID "+tourist.getTid()+" updated";
			}
		 else {
			throw new TouristNotFoundException("Tourist ID not found for record update");
		}
	}

	@Override
	public String updateTouristBudget(Integer tid, Double tbudget) throws TouristNotFoundException {
		Optional<Tourist> optional = repo.findById(tid);
		if(optional.isPresent()) {
			Tourist tourist = optional.get();
			tourist.setBudget(tbudget);
			repo.save(tourist);
			return "Tourist budget with ID "+optional.get().getTid()+" updated";
		}
		else {
			throw new TouristNotFoundException("Tourist ID not found for record update");
		}
	}

	@Override
	public String deleteTouristById(Integer tid) throws TouristNotFoundException {
		Optional<Tourist> optional = repo.findById(tid);
		if (optional.isPresent()) {
			repo.deleteById(tid);
			return "Tourist with ID "+tid+ " is deleted";			
		}
		else {
			throw new TouristNotFoundException("Tourist ID "+tid+" not found for record deletion");
		}
	}

}
