package OLLPackage;

public class WithdrawalThread extends Thread {
	
	private TDBank bank;

	public WithdrawalThread(TDBank bank) {
		super();
		this.bank = bank;
	}
	
	@Override
	public void run() {
		System.out.println("Withdrawal thread starting");
		bank.withdrawal(2000);
	}

}
