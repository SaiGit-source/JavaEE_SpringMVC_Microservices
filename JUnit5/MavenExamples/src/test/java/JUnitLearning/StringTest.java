package JUnitLearning;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import basic.Calc;
import basic.StringReverse;

public class StringTest {

	@Test
	void test() {
		System.out.println("String test");	
		StringReverse str = new StringReverse();
		String actual=str.reversedString("Java");
		String expectedResult = "avaJ";
		assertEquals(expectedResult, actual); // pass in expected result then actual result
		assertEquals("neilA", str.reversedString("Alien"));
	}

	
}
