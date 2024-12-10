package com.SpringSecurity.SessionExample.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.SpringSecurity.SessionExample.model.Users;
import com.SpringSecurity.SessionExample.repo.IUserRepo;

@Service
public class MyUserDetailsService implements UserDetailsService {
	
	@Autowired
	private IUserRepo repo;

	// the overridden method needs UserDetails as return type
	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		Users users = repo.findByName(userName);
		if(users==null) {
			throw new UsernameNotFoundException("user not found 404");
		}
		return new UserPrincipal(users); //we cannot return users as class Users
	}

}
