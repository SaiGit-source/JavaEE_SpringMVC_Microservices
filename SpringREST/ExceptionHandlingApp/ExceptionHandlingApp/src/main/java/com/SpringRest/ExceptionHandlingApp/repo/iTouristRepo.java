package com.SpringRest.ExceptionHandlingApp.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.SpringRest.ExceptionHandlingApp.model.Tourist;

public interface iTouristRepo extends JpaRepository<Tourist, Integer> {

}
