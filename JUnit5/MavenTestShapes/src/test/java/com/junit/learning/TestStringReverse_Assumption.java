package com.junit.learning;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.assumeFalse;
import static org.junit.jupiter.api.Assumptions.assumeTrue;

import org.junit.jupiter.api.Test;

// @assumeTrue and @assumeFalse

class TestStringReverse_Assumption {
	StringReverse reverse = new StringReverse();


	@Test
	void testStringReverse_OneWord() 
	{
		String str = "Java";
		assumeFalse(str.equals("JavA")); // only if this line is 'false', the test case will be executed
		assumeTrue(str.length()<5); // only if the str length < 5, the next line will be executed
		// only if Line 16 is true, the following assertions will be tested
		assertEquals("avaJ", reverse.reversedString(str));
		System.out.println("Reverse oneWord test success");
	}

}
