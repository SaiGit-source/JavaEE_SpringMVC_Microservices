package CLLPackage;

public class WithdrawalThread extends Thread {
	
	private BOAbank bank;
	
	
	public WithdrawalThread(BOAbank bank) {
		super();
		this.bank = bank;
	}
	
	@Override
	public void run() {
		System.out.println("Withdrawal thread starting...");
		bank.withdrawal(2000);
	}

}
