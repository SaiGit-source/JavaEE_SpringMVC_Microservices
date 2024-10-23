package com.spring.service;

public class Password {
	
	String algo;
	
	public Password(String algo)
	{
		this.algo=algo;
		System.out.println("Password bean created");
	}
	
	public void passWordAlgoUsed()
	{
		System.out.println("The Algo used for password is "+ algo);
	}


}
