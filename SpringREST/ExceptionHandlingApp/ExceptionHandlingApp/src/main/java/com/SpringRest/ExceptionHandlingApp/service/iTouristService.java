package com.SpringRest.ExceptionHandlingApp.service;

import java.util.List;

import com.SpringRest.ExceptionHandlingApp.exception.TouristNotFoundException;
import com.SpringRest.ExceptionHandlingApp.model.Tourist;

public interface iTouristService {
	
	public List<Tourist> fetchAllTourists();
	public Tourist fetchTouristById(Integer tid) throws TouristNotFoundException;
	public String registerTourist(Tourist tourist);
	
	public String updateTouristInfo(Tourist tourist) throws TouristNotFoundException;
	public String updateTouristBudget(Integer tid, Double tbudget) throws TouristNotFoundException;
	public String deleteTouristById(Integer tid) throws TouristNotFoundException;

}
