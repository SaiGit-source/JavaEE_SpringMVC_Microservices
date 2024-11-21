package com.SpringRest.ExceptionHandlingApp.service;

import java.util.List;

import com.SpringRest.ExceptionHandlingApp.exception.TouristNotFoundException;
import com.SpringRest.ExceptionHandlingApp.model.Tourist;

public interface iTouristService {
	
	public List<Tourist> fetchAllTourists();
	public Tourist fetchTouristById(Integer tid) throws TouristNotFoundException;
	public String registerTourist(Tourist tourist);

}
