package com.junit.learning;

import static org.junit.jupiter.api.Assertions.*;

import java.time.Duration;

import org.junit.jupiter.api.Test;

// assertTimeout() we can check the performance of the method
class TestingPerformanceTest {

	@Test
	void testPerformance_fail() {
		TestingPerformance testP = new TestingPerformance();
		assertTimeout(Duration.ofMillis(10),()->testP.testPerformance());
	}
	
	@Test
	void testPerformance_pass() {
		TestingPerformance testP = new TestingPerformance();
		assertTimeout(Duration.ofMillis(100),()->testP.testPerformance());
	}

}
