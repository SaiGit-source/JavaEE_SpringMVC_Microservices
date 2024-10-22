package com.junit.learning;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

// multiple tests
class StringReverseTest {
	
	StringReverse reverse = new StringReverse();

	@Test
	void testReverseString_OneWord() {
		// StringReverse reverse = new StringReverse();
		assertEquals("avaJ", reverse.reversedString("Java"));
	}
	
	// for testing only one unit test, we right click the test and run
	@Test
	void testReverseString_MultipleWords() {
		// StringReverse reverse = new StringReverse();
		assertEquals("ysae si avaJ", reverse.reversedString("Java is easy"));		
	}
	
}
