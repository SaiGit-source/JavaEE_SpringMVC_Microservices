package Examples;

import java.util.Scanner;

public class ExceptionHandlingPart2 {
// two takeways - 1. split two different concepts with two different try block
	// 2. one try can have multiple catch blocks
	// have a default catch block for safety
	// 3 ways in Exceptions: Handling (try catch), ducking(throws in method()), re-throw(throw in body)
	// this example is handling exceptions
	
	public static void main(String[] args) {
		System.out.println("Connection created");
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
			System.out.println("Exception: Please enter non-zero denominator");
		}
		
		// next concept is array so use a different try block so even after exception in division program will continue to Array part
		try {
			System.out.print("Enter the array size: ");
			int n = scan.nextInt();
			int[] ar = new int[n];
			System.out.printf("Array of size %d created\n", n);
			System.out.print("Enter the num to be inserted: ");
			int digit = scan.nextInt();
			System.out.print("Enter the index: ");
			int index = scan.nextInt();
			ar[index] = digit;
			System.out.println("Number inserted is: "+ar[index]);
		}
		catch (NegativeArraySizeException e) {
			System.out.println("Exception: Array size cannot be negative");
		}
		catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("Exception: Enter index within array size");
		}
		catch (Exception e) {
			System.out.println("Exception: Some problem occured");
			// lets see we haven;t foreseen a problem like entering string for integer as input etc
			// so we have a default Exception
		}
		// when exception is handled, line after the problem statement wont get executed still connection is gracefully terminated
		
		scan.close();
		System.out.println("Connection terminated");

	}

}
