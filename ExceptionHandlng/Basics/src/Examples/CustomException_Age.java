package Examples;

import java.util.Scanner;

class UnderAgeException extends Exception{
	public UnderAgeException(String msg) {
		super(msg);
	}
}

class OverAgeException extends Exception{
	public OverAgeException(String msg) {
		super(msg);
	}
}

class Office{
	int age;
	
	public void input() {
		Scanner scan = new Scanner(System.in);
		System.out.print("Enter your age to start application: ");
		age=scan.nextInt();
	}
	
	public void verifyAge() throws UnderAgeException, OverAgeException {
		if (age>=18 && age<=60) {
			System.out.println("Age verified: Please start the applicaton");
		}
		else if (age<18){
			UnderAgeException uae = new UnderAgeException("User is under age");
			System.out.println(uae.getMessage());
			throw uae;
		}
		else {
			OverAgeException oae = new OverAgeException("User is over age");
			System.out.println(oae.getMessage());
			throw oae;	
		}
	}
}

class AppInitiator{
	public void initiate() {
		Office office = new Office();
		
		try {
			office.input();
			office.verifyAge();
		} catch (UnderAgeException | OverAgeException e) {
			System.out.println("Try Again! 2nd attempt");
			try {
				office.input();
				office.verifyAge();
			} catch (UnderAgeException | OverAgeException e1) {
				System.out.println("Try Again! all attempts failed application blocked");
			}
		}
	}
}

public class CustomException_Age {

	public static void main(String[] args) {
		AppInitiator app = new AppInitiator();
		app.initiate();
	}

}
