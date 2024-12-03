package com.SpringRest.MokitoTest.service;

import java.time.LocalDateTime;

import org.springframework.stereotype.Service;

import com.SpringRest.MokitoTest.model.Student;

@Service
public class GeneralService implements IGeneralService {

	@Override
	public String generateGreeting(String name) {
		LocalDateTime time = LocalDateTime.now();
		int hour = time.getHour();
		if(hour < 12) {
			return "Good morning "+name;
		}
		if(hour < 16) {
			return "Good afternoon "+name;
		}
		if(hour < 20) {
			return "Good evening "+name;
		}
		else {
				return "Good night "+name;
			}
	
	}

	@Override
	public Boolean addStudent(Student student) {
		System.out.println(student);
		return true;
	}

}
