package com.springrest.AOP.GlobalExHandling.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springrest.AOP.GlobalExHandling.model.Tourist;

public interface iTouristRepo extends JpaRepository<Tourist, Integer> {

}
