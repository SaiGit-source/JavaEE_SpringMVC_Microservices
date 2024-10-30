package com.springboot.SpringDataJPA;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.springboot.SpringDataJPA.entity.Person;
import com.springboot.SpringDataJPA.repo.PersonInterfaceJPA;

@Component
public class DataJPARunner implements CommandLineRunner {
	
	@Autowired
	private PersonInterfaceJPA personI;

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Interface name is: "+personI.getClass().getName());
		// methods come from CrudRepository
		// Person person = new Person(1, "Abc", "Charlotte");
		// set spring.jpa.hibernate.ddl-auto=update then run the next line
		Person person = new Person(2, "Xyz", "Nashville");
		personI.save(person);
	}
	
}
