package Examples;

import java.util.Scanner;
// example of exception handling
class Calc{
	public void divide() {
		System.out.println("Calc Connection created");
		Scanner scan = new Scanner(System.in);
		try {
			System.out.print("Enter the numerator: ");
			int num = scan.nextInt();
			System.out.print("Enter denominator: ");
			int den = scan.nextInt();
			int res = num / den; // risky statement
			System.out.println("Answer is: "+res);
		}
		catch (ArithmeticException e) {
			System.out.println("Exception from Calc: Please enter non-zero denominator");
		}
// handling Exception within body of method, correct way to do
		// when exception is handled in Calc class, it will not go to main() method exception
	}
}

class MiddleMan{
	public void disp() {
		System.out.println("MiddleMan Connection Established");
		Calc calc = new Calc();
		calc.divide();
		System.out.println("MiddleMan Connection Terminated");
	}
}


public class ExceptionHandling2_1 {

	public static void main(String[] args) {
		System.out.println("Main method Connection Established");
		MiddleMan mid = new MiddleMan();
		try {
			mid.disp();
		}
		catch (Exception e) {
			System.out.println("Exception: some problem in main() method");
		}// if exception is already handled by any of the previous classes, it will not execute this exception, it will instead terminate
		
		System.out.println("Main method Connection Terminated");
	}

}
