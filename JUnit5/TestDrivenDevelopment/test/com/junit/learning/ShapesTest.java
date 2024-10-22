package com.junit.learning;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

// i write the assertion logic before writing any logic in the methods

class ShapesTest {
	
	Shapes shape = new Shapes();

	@Test
	void testComputeSquareArea() 
	{
		assertEquals(576, shape.computeSquareArea(24));
	}
	
	@Test
	void testComputeCircleArea()
	{
		assertEquals(78.5, shape.computeCircleArea(5), "Area of circle calculation is incorrect");
	}

}
