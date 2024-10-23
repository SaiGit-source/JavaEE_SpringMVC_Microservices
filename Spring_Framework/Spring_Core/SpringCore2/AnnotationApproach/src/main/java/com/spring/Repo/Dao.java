package com.spring.Repo;

import org.springframework.stereotype.Repository;

@Repository // Repository = @Component + Repo logic (database logic)
public class Dao {
	
	public Dao()
	{
		System.out.println("DAO bean created");
	}

}
