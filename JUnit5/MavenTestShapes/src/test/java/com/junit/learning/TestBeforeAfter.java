package com.junit.learning;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/* Output
 * 	Before test
	Actual test running
	After test
	Before test
	Actual test running
	After test
*/

class TestBeforeAfter {
	
	Shapes shape = null;
	
	@BeforeEach // before running tests, init() method will be executed
	void init()
	{
		shape = new Shapes();
		System.out.println("Before test");
	}

	@Test
	void testComputeSquareArea() 
	{	//non-static methods so we create objects
		assertEquals(576, shape.computeSquareArea(24));
		System.out.println("Actual test running");
	}
	
	@Test
	void testComputeCircleArea()
	{
		assertEquals(78.5, shape.computeCircleArea(5), ()->"Area of circle calculation is incorrect");
		System.out.println("Actual test running");
	}
	
	@AfterEach // after every test this function would be executed
	void destroy()
	{
		System.out.println("After test");
	}


}
