package Examples;

import java.util.Scanner;

public class EHBasic {
	// exception occurs only during runtime, if a runtime error occurs within a method, the method stack creates an exception object.
	// if exception is not handled then it goes to default handler the problem is, the default handler leads to abnormal applicaiton termination
	// for graceful termination of application, we need exception handling that can be achieved by try-catch{}
	
	public static void main(String[] args) {
		try {	
			System.out.println("Program started");
			Scanner scan = new Scanner(System.in);
			System.out.print("Enter numerator: ");
			int num = scan.nextInt();
			System.out.print("Enter denominator: ");
			int den = scan.nextInt();
			int div = num / den; // this is the risky line because if someone enters 0 in den then it throws an exception
			System.out.println("Div is: "+div);
		}
		catch(Exception e){
			System.out.println(e+" enter non-zero number");
		}
		
	System.out.println("Program terminated"); // now program will terminate smoothly even with errors because of exception handling
	}

}
