package com.SpringProfile.ProfileExample.service;

import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Primary
@Profile({"sb1", "sb2"})
public class SpringBoot implements ICourse {

	public SpringBoot() {
		System.out.println("SpringBoot bean created");	
	}
	
	@Override
	public String purchaseCourse(Double amount) {
		return "SpringBoot course purchased for "+amount;
	}

}
