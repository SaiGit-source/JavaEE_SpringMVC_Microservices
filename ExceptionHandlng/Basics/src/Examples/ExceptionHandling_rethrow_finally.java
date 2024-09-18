package Examples;

import java.util.Scanner;

class Calc_rethrow{
	public void divide(){ // this is re-throw: because we are handling exception in this method() only still we are propagating to main() method / caller and it will throw exception inside main() as well
		System.out.println("Calc Connection created");
		Scanner scan = new Scanner(System.in);
		try {	
			System.out.print("Enter the numerator: ");
			int num = scan.nextInt();
			System.out.print("Enter denominator: ");
			int den = scan.nextInt();
			int res = num / den; // risky statement
		}
		catch (ArithmeticException e) {
			System.out.println("Exception from Calc class: Please enter non-zero denominator");
			throw e; // this thread will exit and go back to caller method()
		}
		finally {
			System.out.println("Calc_rethrow Connection Terminated from finally block");
		} // finally block is executed no matter whether exception is there or not or exception is handled or not
		// even if exception is not handled this will run
		// it will get executed even with throw statement
	}
}

class MiddleMan_rethrow{
	public void disp() {
		System.out.println("MiddleMan Connection Established");
		Calc_rethrow calc = new Calc_rethrow();
		calc.divide();
		System.out.println("MiddleMan Connection Terminated");
	}
}


public class ExceptionHandling_rethrow_finally {

	public static void main(String[] args) {
		System.out.println("Main method Connection Established");
		MiddleMan_rethrow mid = new MiddleMan_rethrow();
		try {
			mid.disp();
		}
		catch (Exception e) {
			System.out.println("Exception: some problem in main() method");
		} // in re-throw, we are propagating exceptions to the caller class as well even though we have handled in the previous class. sort of redundant but for some reasons we are informing the caller class well
		// now both exception messages are printed in the console because of throw statement
		// 'Calc_rethrow Connection Terminated from finally block' is printed even with throw statement because of finally block
		
		System.out.println("Main method Connection Terminated");
	}

}
