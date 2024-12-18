package com.SpringBoot.ConfigClient.rest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

// msg key comes directly from Git through CloudConfigServer

@RestController
public class ClientController {
	
	@Value("${msg}")
	private String msg;
	
	@GetMapping("/get-message")
	public String getMessage()
	{
		return msg;
	}

}
