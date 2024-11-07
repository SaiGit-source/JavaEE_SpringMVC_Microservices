package com.springdatajpa.MongoDBExample.repo;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.springdatajpa.MongoDBExample.model.Customer;

public interface CustInterfaceRepo extends MongoRepository<Customer, String>{
	// id is String

}
