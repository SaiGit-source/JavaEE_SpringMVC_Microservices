package com.Thymeleaf.ThymeleafCSS.repo;

import org.springframework.data.repository.CrudRepository;

import com.Thymeleaf.ThymeleafCSS.model.Customer;

public interface iCustomerRepo extends CrudRepository<Customer, Integer> {

}
