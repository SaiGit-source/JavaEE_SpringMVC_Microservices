package com.SpringSecurity.SessionExample.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.SpringSecurity.SessionExample.model.Users;
import com.SpringSecurity.SessionExample.repo.IUserRepo;

@Service
public class UserService {
	
	@Autowired
	private IUserRepo repo;
	
	public Users saveNewUser(Users user) {
		return repo.save(user);
	}

}
