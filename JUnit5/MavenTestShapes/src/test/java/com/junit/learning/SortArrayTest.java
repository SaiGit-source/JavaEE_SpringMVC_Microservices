package com.junit.learning;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class SortArrayTest {

	@Test
	void testSortingArray_Exception() {
		
		try
		{
			SortArray array = new SortArray();
			//int[] unsorted = {2,4,5};
			int[] unsorted = null;
			int[] sortedArray = array.sortingArray(unsorted); // if exception is generated here, catch() block will get executed
			for (int elem : sortedArray) {
				System.out.println(elem);
			}
			System.out.println("Statements below exception");
			fail();
		}
		catch(NullPointerException e) {
			System.out.println("Exception generated");
		}
		
	}

}
