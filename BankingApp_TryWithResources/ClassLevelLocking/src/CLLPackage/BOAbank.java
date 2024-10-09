package CLLPackage;
// to demonstrate class level locking, we got to convert all methods and variables into static so we can access them from class level like className.method()
// if locking is applied to class level, then another thread cannot run any objects of the same class. but in Object level locking, another thread can run another object of the same class. that's the difference


public class BOAbank {
	static int accountBal; // make it static so it loads into memory during class loading time
	
	/*
	public BOAbank(int accountBal) {
		super();
		this.accountBal = accountBal;
	}
	*/
	
	synchronized static public void deposit(int deposit) {
		accountBal = accountBal + deposit;
	}
	
	synchronized static public void withdrawal(int withdrawal) {
		if (withdrawal <= accountBal) {
			accountBal = accountBal - withdrawal;
		}
		else {
			System.out.println("Withdrawal not possible because withdrawal amount > accountBal");
		}
	}
	
	synchronized static public void checkBalance() {
		System.out.println("The current balance is: "+accountBal);
	}

}
