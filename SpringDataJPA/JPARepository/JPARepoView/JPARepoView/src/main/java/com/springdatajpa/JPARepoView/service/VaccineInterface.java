package com.springdatajpa.JPARepoView.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.springdatajpa.JPARepoView.view.View;

@Service
public interface VaccineInterface {
	
	public<T extends View> List<T>fetchByCostLessThan(Double price, Class<T> cls);
}
