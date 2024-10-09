package OLLPackage;

public class TDBank {
	int accountBal;

	public TDBank(int accountBal) {
		super();
		this.accountBal = accountBal;
	}
	
	synchronized public void deposit(int deposit) {
		accountBal = accountBal + deposit;
	}
	
	synchronized public void withdrawal(int withdrawal) {
		if (withdrawal <= accountBal) {
			accountBal = accountBal - withdrawal;
		}
		else {
			System.out.println("Withdrawal not possible because withdrawal amount > accountBal");
		}
	}
	
	synchronized public void checkBalance() {
		System.out.println("The current balance is: "+accountBal);
	}

}
