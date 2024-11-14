package com.springmvc.CRMWebApplication.repo;

import org.springframework.data.repository.CrudRepository;

import com.springmvc.CRMWebApplication.model.Customer;

public interface ICustomerRepo extends CrudRepository<Customer, Integer> {

}
