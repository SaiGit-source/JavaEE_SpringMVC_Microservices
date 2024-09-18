package Examples;

import java.util.Scanner;
// example of Exception ducking

class Calc_duck{
	public void divide() throws ArithmeticException{ // this is ducking because there is no try catch block, we are informing the developer that this method() could potentially throw exception so now developer will implement try catch in main() method. this is the base minimum we should do otherwise immoral
		System.out.println("Calc Connection created");
		Scanner scan = new Scanner(System.in);
			System.out.print("Enter the numerator: ");
			int num = scan.nextInt();
			System.out.print("Enter denominator: ");
			int den = scan.nextInt();
			int res = num / den; // risky statement
	}
}

class MiddleMan_duck{
	public void disp() {
		System.out.println("MiddleMan Connection Established");
		Calc_duck calc = new Calc_duck();
		calc.divide();
		System.out.println("MiddleMan Connection Terminated");
	}
}


public class ExceptionHandling2_duck {

	public static void main(String[] args) {
		System.out.println("Main method Connection Established");
		MiddleMan_duck mid = new MiddleMan_duck();
		try {
			mid.disp();
		}
		catch (Exception e) {
			System.out.println("Exception: some problem in main() method");
		} // we are handling exception in main() method because previous method doesn't and it ducks
		
		System.out.println("Main method Connection Terminated");
	}

}
