package com.spring.web;

import org.springframework.stereotype.Controller;

@Controller //  @Component + web logic (specific purpose)
public class Web {

	public Web() {
		super();
		System.out.println("Web bean created");
	}

}
