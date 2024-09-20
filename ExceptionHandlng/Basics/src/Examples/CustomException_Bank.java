package Examples;

import java.util.Scanner;

// we create custom exceptions if generic ones dont fit our needs like Invalid credentials or Invalid age
// also it helps precisely control program flow

class InvalidCustomerException extends Exception{
	public InvalidCustomerException(String msg) {
		super(msg); // it goes to super class, which is Exception in this case
		// it can be accessed with getMessage() inherited method
	}
}

class ATM{
	int acct = 4545; // original credentials
	int pwd = 1234;
	int usrAcct;
	int usrPwd;
	
	public void input() {
		Scanner scan = new Scanner(System.in);
		System.out.print("Enter Account no: ");
		usrAcct=scan.nextInt();
		System.out.print("Enter Password: ");
		usrPwd=scan.nextInt();
	}
	
	public void verifyCred() throws InvalidCustomerException {
		if (usrAcct==acct && usrPwd==pwd) {
			System.out.println("User validated: proceed to withdraw amount");
		}
		else {
			InvalidCustomerException ice = new InvalidCustomerException("Invalid credentials!");
			System.out.println(ice.getMessage()); // this is an inherited method from Exception
			throw ice; // we are throwing the exception in case of else 
		}
	}

}

class Bank{// the bank will initiate this process
	public void initiate() {
		ATM atm = new ATM();
		
		try {
			atm.input();
			atm.verifyCred(); // it prompts to surround with try catch because it throws exception
		} catch (InvalidCustomerException e2) {
			// whenever it throws ice exception it comes into this catch block
			System.out.println("Try again 2nd attempt");
			
			try {
				atm.input();
				atm.verifyCred(); // it prompts to surround with try catch because it throws exception
			} catch (InvalidCustomerException e3) {
				// whenever it throws ice exception it comes into this catch block
				System.out.println("Try again 3rd attempt");

				try {
					atm.input();
					atm.verifyCred(); // it prompts to surround with try catch because it throws exception
				} catch (InvalidCustomerException e4) {
					// whenever it throws ice exception it comes into this catch block
					System.out.println("Sorry all 3 attempts over, account is blocked!");
				}
			}
			
		}
	
	
	}
	
	
}

public class CustomException_Bank {

	public static void main(String[] args) {
		Bank bank = new Bank();
		bank.initiate();
	}

}
