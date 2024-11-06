package com.springdatajpa.JPARepoView.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springdatajpa.JPARepoView.model.Vaccine;
import com.springdatajpa.JPARepoView.view.View;

@Repository
public interface VacInterfaceRepo extends JpaRepository<Vaccine, Integer> {

	// https://docs.spring.io/spring-data/jpa/reference/repositories/query-keywords-reference.html
	// for custom search we write methods in here
	//findBy-propertyName-keyword
	public<T extends View> List<T>findByPriceLessThan(Double price, Class<T> cls);

}
