package com.SpringProfile.ProfileExample.service;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile("devops")
public class DevOps implements ICourse {

	public DevOps() {
		System.out.println("DevOps bean created");	
	}
	
	@Override
	public String purchaseCourse(Double amount) {
		return "DevOps course purchased for "+amount;
	}

}
