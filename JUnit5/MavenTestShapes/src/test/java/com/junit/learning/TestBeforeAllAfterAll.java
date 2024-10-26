package com.junit.learning;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

/* OUTPUT before @TestInstance -> constructor of this test class is being executed twice before the two tests 
Before All tests
Constructor: Test object is created before test method
Before test
Actual test running
After test cleanup
Constructor: Test object is created before test method
Before test
Actual test running
After test cleanup
All tests ran 
*/


/* OUTPUT after @TestInstance -> Constructor of this test class is executed only once
 *  
 * Constructor: Test object is created before test method
Before All tests
Before test
Actual test running
After test cleanup
Before test
Actual test running
After test cleanup
All tests ran
 * 
 */


@TestInstance(TestInstance.Lifecycle.PER_CLASS) // we are telling to create the instance or object (of this test class) only once here
// we are executing constructor of this test class only once
class TestBeforeAllAfterAll {
	
	Shapes shape = null;

	public TestBeforeAllAfterAll() {
		super();
		System.out.println("Constructor: Test object is created before test method");
	}


	@BeforeAll // usually for a static method, independent of instance
	// before Constructor execution, this method is being called. it gets executed during the class loading time
	// method common for all tests like DB activities (establishing connection to DB or seeding DB with data)
	// this method only runs once
	static void setUpBeforeClass() throws Exception 
	{
		System.out.println("Before All tests"); // this will get only get executed only once
	}
	
	
	@AfterAll()
	static void afterAll()
	{
		System.out.println("All tests ran");
	}


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
		System.out.println("After test cleanup");
	}
	


}
