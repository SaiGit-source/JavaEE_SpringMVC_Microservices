package com.SpringRest.MokitoTest.service;

import com.SpringRest.MokitoTest.model.Student;

public interface IGeneralService {
	
	public String generateGreeting(String name);
	public Boolean addStudent(Student student);

}
