package com.junit.learning;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

class ShapesTest {

	@Test
	void test() 
	{
		assertEquals(6, 6);
	}
	// from JUnit5 , methods dont have to be public
	Shapes shape = new Shapes();

	@Test
	void testComputeSquareArea() 
	{	
		assertEquals(576, shape.computeSquareArea(24));
	}
	
	// right-click RunAs Maven Test
	
	/* Surefire plugin without Eclipse IDE feature to run tests
	 * [INFO] Tests run: 3, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 0.062 s -- in com.junit.learning.[1mShapesTest[m
	 * [INFO] Tests run: 3, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 0.062 s
	 * [INFO] BUILD SUCCESS
	 */
	
	@Test
	void testComputeCircleArea()
	{
		// when passing String directly, that String object (message) is being evaluated regardless of the test status. if the test fails, it will display that message otherwise, the message is not displayed
		// even if test case passes, display of the error message doesn't happen however the String object is evaluated behind the scene
		assertEquals(78.5, shape.computeCircleArea(5), "Area of circle calculation is incorrect");
	}
	
	@Test
	void testComputeCircleArea_SupplierInterface()
	{
		// Supplier Java interface is a functional interface so lambda implementation
		// here the function gets executed only if test case fails. String is printed only if the test case fails, otherwise the function is not executed that's the difference
		// this option is more efficient, if test case is failing
		// SupplierInterface() option is more efficient always
		assertEquals(78.5, shape.computeCircleArea(5), ()->"Area of circle calculation is incorrect");
	}
	
	//assertNotEquals() method supplier interface -> lazy evaluation
	@Test
	void testComputeCircleAreaNotEquals()
	{
		assertNotEquals(45, shape.computeCircleArea(5), ()->"Message if testcase fail");
	}
	
	// assertTrue
	@Test
	void testAssertTrue()
	{
		String str = "JUnit";
		assertTrue(str.equals("JUnit"));
	}
	
	
	// assertFalse
	@Test
	void testAssertFalse()
	{
		String str = "JUnit";
		assertFalse(str.equals("JUNIT"));
	}
	
	// Assertion over array
	
	@Test
	void testArrays()
	{
		int[] expected = {2,4,6,8};
		int[] actual = {4,8,6,2}; // Actual without sorting -> org.opentest4j.AssertionFailedError: array contents differ at index [0], expected: <2> but was: <4>
		Arrays.sort(actual);
		assertArrayEquals(expected, actual); // after sorting, num of elements in both arrays are the same, elements in them are the same, order of elements are the same as well
		//assertEquals(expected, actual); // this will fail because it is comparing the reference variables not data within those references
		//assertArrayEquals will check the data inside the references
	}
	

}
