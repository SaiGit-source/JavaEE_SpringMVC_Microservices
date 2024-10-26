package com.junit.learning;

public class Shapes 
{	// first i write the tests then i develop logic
	public double computeSquareArea(double length) 
	{
		
		double res = length * length;
		return res;
	}
	
	// first write tests then develop logic to make unit test case pass
	
	public double computeCircleArea(double radius) {
		// return radius;
		return 3.14 * radius * radius;
	}

	public double computeRectArea(double length) {
		// Logic is not yet developed;
		return 0;
	}
	
}
