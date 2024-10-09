package CLLPackage;

public class CheckBalanceThread extends Thread {
	
	private BOAbank bank;

	
	public CheckBalanceThread(BOAbank bank) {
		super();
		this.bank = bank;
	}
	
	@Override
	public void run() {
		System.out.println("Check balance thread starting...");
		bank.checkBalance();
	}

}
