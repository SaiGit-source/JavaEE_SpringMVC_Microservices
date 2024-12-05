package com.SpringAOP.AOPExample.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.SpringAOP.AOPExample.model.Person;

public interface IPersonRepo extends JpaRepository<Person, Long> {

}
