package OLLPackage;

// these are independent activities so different threads

public class DepositThread extends Thread {
	private TDBank bank;
		
	public DepositThread(TDBank bank) {
		super();
		this.bank = bank;
	}

	@Override
	public void run() {
		System.out.println("Deposit Thread starting");
		bank.deposit(4000); // here deposit is default to 4000 however we could get input from users also
	}
	
}
