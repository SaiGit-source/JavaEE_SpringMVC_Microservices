package com.Thymeleaf.CRMWebApp.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.Thymeleaf.CRMWebApp.model.Customer;

@Repository
public interface iCustomerRepo extends CrudRepository<Customer, Integer> {

}
