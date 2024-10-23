package com.spring.service;

import org.springframework.stereotype.Service;

@Service("service") // default name will be serviceLayer, here it is service
public class serviceLayer {
	
	public serviceLayer()
	{
		System.out.println("ServiceLayer bean created");
	}


}
