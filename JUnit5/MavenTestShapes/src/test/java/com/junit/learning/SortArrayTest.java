package com.junit.learning;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

class SortArrayTest {

	@Test
	void testSortingArray_Exception() {
		
		try
		{
			SortArray array = new SortArray();
			//int[] unsorted = {2,4,5};
			int[] unsorted = null;
			// exception will be generated at line 17
			int[] sortedArray = array.sortingArray(unsorted); // if exception is generated here, catch() block will get executed
			for (int elem : sortedArray) {
				System.out.println(elem);
			}
			System.out.println("Statements below exception");
			// explicit fail() is before the catch() block after exception generating statement
			// fail();
		}
		catch(NullPointerException e) {
			System.out.println("Exception generated");
		}
		
	//assertThrows() method
	@Test
	void testSortingArray_NullException_fail() {
		
		try
		{
			int[] unsorted = {2,4,5};
			SortArray array = new SortArray();
			assertThrows(NullPointerException.class, ()->array.sortingArray(unsorted));
			// if array.sortingArray(unsorted) is generating NullPointerException, test case is passing, in this case, it will designed to fail
		}
		catch(NullPointerException e) {
			System.out.println("Exception generated");
		}
		
	}

	@Timeout(value=100) // timeout to test performance of a unit
	@Test
	void testSortingArray_NullException_success() {
		
		try
		{
			int[] unsorted = null;
			SortArray array = new SortArray();
			assertThrows(NullPointerException.class, ()->array.sortingArray(unsorted));
			// if array.sortingArray(unsorted) is generating NullPointerException, test case is passing
		}
		catch(NullPointerException e) {
			System.out.println("Exception generated");
		}
		
	}


}
