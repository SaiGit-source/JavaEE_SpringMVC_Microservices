package OLLPackage;

public class CheckBalanceThread extends Thread {
	
	private TDBank bank;

	public CheckBalanceThread(TDBank bank) {
		super();
		this.bank = bank;
	}
	
	@Override
	public void run() {
		System.out.println("Check balance thread starting...");
		bank.checkBalance();
	}

}
