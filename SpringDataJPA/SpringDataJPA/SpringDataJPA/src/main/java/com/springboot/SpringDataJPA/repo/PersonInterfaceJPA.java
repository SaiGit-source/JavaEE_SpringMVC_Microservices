package com.springboot.SpringDataJPA.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.springboot.SpringDataJPA.entity.Person;

@Repository
public interface PersonInterfaceJPA extends CrudRepository<Person, Integer>
{
// what object you want to store in database and primary key datatype
// <Person, PrimaryKey type>
// implementation is already there
}
