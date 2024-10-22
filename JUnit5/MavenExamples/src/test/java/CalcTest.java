import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import basic.Calc;

class CalcTest {

	@Test
	void test() {
		System.out.println("First JUnit run");	
		Calc calc = new Calc();
		int actual=calc.divide(10, 5);
		int expectedResult = 2;
		assertEquals(expectedResult, actual); // pass in expected result then actual result
		}

}
