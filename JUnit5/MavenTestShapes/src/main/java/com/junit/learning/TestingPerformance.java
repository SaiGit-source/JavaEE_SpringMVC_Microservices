package com.junit.learning;

// lets say i have a function and it needs to finish within 10 milli sec, otherwise, it has failed.
// we test performance of a longer running unit

public class TestingPerformance {
	
	public void testPerformance() throws InterruptedException {
		for (int i=0; i<10; i++) {
			Thread.sleep(5);
		}
	}

}
