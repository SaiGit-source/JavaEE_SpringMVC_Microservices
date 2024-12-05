package com.SpringAOP.AOPExample.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.SpringAOP.AOPExample.model.Person;

@Service
public interface IPersonService {

	public Person registerPerson(Person person);
	public List<Person> getAllPersonInfo();
}
