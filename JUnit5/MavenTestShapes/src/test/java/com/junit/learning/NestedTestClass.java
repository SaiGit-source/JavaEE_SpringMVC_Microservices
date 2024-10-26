package com.junit.learning;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

// @Nested groups unit tests together

class NestedTestClass {
	StringReverse reverse = null;
	@BeforeEach
	void init()
	{
		reverse = new StringReverse();
 
	}
	
	@Nested
	class ReverseStringTest
	{
		// all test cases to test reverse string unit
		@Test
		void testSortingArray_Exception() {
			
				SortArray array = new SortArray();
				int[] unsorted = {2,4,5};
				// int[] unsorted = null;
				// exception will be generated at line 17
				int[] sortedArray = array.sortingArray(unsorted); // if exception is generated here, catch() block will get executed
				for (int elem : sortedArray) {
					System.out.println(elem);
				}
				System.out.println("Statements below exception");
				// explicit fail() is before the catch() block after exception generating statement
				// fail();
			}
			

		@Timeout(value=100) // timeout to test performance of a unit
		@Test
		void testSortingArray_NullException_success() {
			
				int[] unsorted = null;
				SortArray array = new SortArray();
				assertThrows(NullPointerException.class, ()->array.sortingArray(unsorted));
				// if array.sortingArray(unsorted) is generating NullPointerException, test case is passing
			
		}
		
		
	}
	
	@Nested
	class SortingTests
	{
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

}
