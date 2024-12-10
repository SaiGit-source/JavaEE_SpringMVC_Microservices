package com.SpringSecurity.SessionExample.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.SpringSecurity.SessionExample.model.Users;

public interface IUserRepo extends JpaRepository<Users, String> {
	public Users findByName(String userName); // custom query method
}
