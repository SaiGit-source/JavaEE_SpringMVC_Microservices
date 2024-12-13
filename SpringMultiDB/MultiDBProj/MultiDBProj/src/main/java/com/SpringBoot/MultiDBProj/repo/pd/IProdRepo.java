package com.SpringBoot.MultiDBProj.repo.pd;

import org.springframework.data.jpa.repository.JpaRepository;

import com.SpringBoot.MultiDBProj.model.product.Product;

public interface IProdRepo extends JpaRepository<Product, Integer>  {

}
