package com.SpringBoot.MultiDBProj.repo.cx;

import org.springframework.data.jpa.repository.JpaRepository;

import com.SpringBoot.MultiDBProj.model.customer.Customer;

public interface ICustRepo extends JpaRepository<Customer, Integer> {

}
