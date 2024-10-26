package com.junit.learning;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.assumeTrue;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.condition.EnabledForJreRange;
import org.junit.jupiter.api.condition.EnabledOnOs;
import org.junit.jupiter.api.condition.JRE;
import org.junit.jupiter.api.condition.OS;

// @DisplayName is very handy when we have many test cases in the file
// @Disabled will skip the unit test
// @EnabledOnOs(OS.WINDOWS)  this test will run only if OS is Windows -> Conditional TestExecution
// @EnabledOnJre(JRE.JAVA_11) runs only on Java 11
// @EnabledForJreRange(min=JRE.JAVA_8, max=JRE.JAVA_22)

@TestInstance(TestInstance.Lifecycle.PER_CLASS) // we are telling to create the instance or object (of this test class) only once here
//we are executing constructor of this test class only once
class TestDisplayName {
	
	Shapes shape = null;

	public TestDisplayName() {
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
	@DisplayName("Testing Area of Square")
	@EnabledOnOs(OS.WINDOWS) // Conditional TestExecution
	void testComputeSquareArea() 
	{	//non-static methods so we create objects
		assertEquals(576, shape.computeSquareArea(24));
		System.out.println("Actual test running");
	}
	
	@Test
	@DisplayName("Testing Circle Area")
	@EnabledForJreRange(min=JRE.JAVA_8, max=JRE.JAVA_22)
	void testComputeCircleArea()
	{	
		assumeTrue(true);
		assertEquals(78.5, shape.computeCircleArea(5), ()->"Area of circle calculation is incorrect");
		System.out.println("Actual test running - testComputeCircleArea");
	}
	
	@Test
	@Disabled // i dont want to run this test as logic is not yet developed
	@DisplayName("Testing Rect Area")
	void testComputeRectangleArea()
	{
		assertEquals(78.5, shape.computeRectArea(5), ()->"Area of Rectangle calculation is incorrect");
		System.out.println("Actual test running");
	}

	
	@AfterEach // after every test this function would be executed
	void destroy()
	{
		System.out.println("After test cleanup");
	}
	


}
