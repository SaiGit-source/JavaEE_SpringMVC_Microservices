package com.SpringAOP.AOPExample.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.SpringAOP.AOPExample.model.Person;
import com.SpringAOP.AOPExample.repo.IPersonRepo;

@Service
public class PersonService implements IPersonService {

	@Autowired
	private IPersonRepo repo;
	
	@Override
	public Person registerPerson(Person person) {
		
		return repo.save(person); // returns Person object after saving the same
	}

	@Override
	public List<Person> getAllPersonInfo() {
		
		return repo.findAll();
	}

}
