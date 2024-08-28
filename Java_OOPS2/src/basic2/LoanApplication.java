package basic2;

import java.util.Scanner;

// what's needed for Simple interest, principal, term duration and return on investment

class Farmer{
	String name;
	float pa; // these are all instance variables or object variables because they change with objects.
	// different farmers are going to have different principal or loan amounts same with term duration
	float td; 
	float si;
	
	static float roi; // here roi is determined by provider so it doesn't change or determined by farmers. Hence we keep it as static variable
	
	static {
		roi = 2.5f; // roi is constant for all farmers hence declared in static block and it is memory efficient
		// if it was object variable, it would get created every time a new object is created in the memory so not efficient
		// right now, roi is read once into memory during class-loading time and remains constant for all objects
	}
	
	void enterInput() {
		Scanner scan = new Scanner(System.in);// similar to System.out it is System.in
		System.out.print("Please enter your name: ");
		name = scan.next();
		System.out.print("Please enter your Principal or loan amount: ");
		pa = scan.nextFloat();
		System.out.print("Please enter your Term duration: ");
		td = scan.nextFloat();
	}
	
	void computeSI() {
		si = (pa*td*roi)/100.0f;
	}
	
	void disp() {
		System.out.println("Hello "+name +" this is your SI: "+si);
	}
	
}

public class LoanApplication {

	public static void main(String[] args) {
		Farmer farmer1 = new Farmer();
		farmer1.enterInput();
		farmer1.computeSI();
		farmer1.disp();
		System.out.println();
		Farmer farmer2 = new Farmer();
		farmer2.enterInput();
		farmer2.computeSI();
		farmer2.disp();
		System.out.println();
	}

}
