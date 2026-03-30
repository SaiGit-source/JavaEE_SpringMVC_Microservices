package com.microservices.ecommerce.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.microservices.ecommerce.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}
