package CLLPackage;

public class DepositThread extends Thread {
	private BOAbank bank;
	
	
	public DepositThread(BOAbank bank) {
		super();
		this.bank = bank;
	}

	@Override
	public void run() {
		System.out.println("Deposit Thread starting...");
		bank.deposit(5000); // here deposit is default to 4000 however we could get input from users also
	}
	
}
