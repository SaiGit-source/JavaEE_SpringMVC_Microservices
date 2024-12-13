package com.SpringBoot.MultiDBProj.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.SpringBoot.MultiDBProj.model.Product;

public interface IProdRepo extends JpaRepository<Product, Integer>  {

}
