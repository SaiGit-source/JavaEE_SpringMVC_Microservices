package com.junit.learning;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTimeout;

import java.time.Duration;

import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.RepetitionInfo;

// @RepeatedTest to repeat tests 

class RepeatedTest_Example {

	@RepeatedTest(value=4, name= "{displayName} running: {currentRepetition}/{totalRepetitions}")
	void testStringReverse_OneWord(RepetitionInfo info) 
	{
		
		StringReverse reverse = new StringReverse();
		String str = "Java";
		
		assertEquals("avaJ", reverse.reversedString(str));
		System.out.println("Reverse oneWord test success");
	}
	
	@RepeatedTest(value=3)
	void testSortingArray_success(RepetitionInfo info) {
		
			int[] unsorted = {4,2,7,9};
			SortArray array = new SortArray();
			if (info.getCurrentRepetition()==1) 
			{
				System.out.println("Current repetition: "+info.getCurrentRepetition());
				assertTimeout(Duration.ofMillis(50), ()->array.sortingArray(unsorted));
			}
			if (info.getCurrentRepetition()==2) 
			{
				System.out.println("Current repetition: "+info.getCurrentRepetition());
				assertTimeout(Duration.ofMillis(30), ()->array.sortingArray(unsorted));
			}
			
	}
	
}
		

