package com.SpringBoot.MultiDBProj.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.SpringBoot.MultiDBProj.model.Customer;

public interface ICustRepo extends JpaRepository<Customer, Integer> {

}
