package OLLPackage;

public class OLLExample {
	// this is Object Level Locking, we have different threads for different unrelated banking activities like withdrawal, deposit and checkBalance. In OLL, if the object is locked by synchronized method then other threads within the same object goes into Stepping or Blocking mode because resource is locked
	// Debugging notes:
	// put breakpoints in all synchronized methods like synchronized public void deposit
	// put breakpoints in run() methods then step over to see different threads on the side pane
	// when control is in synchronized public void deposit() for example during debugging, we see locking on the side pane, it says owns: TDBank (id=37)
	// at the same time, if i select and run WithdrawalThread, i see Stepping, meaning thread is blocked because we are trying to access the same object this is Object Level Locking

	public static void main(String[] args) {
		
		// Constructor injection here because we are creating an object of bank class and injecting into different thread methods()
		
		TDBank tdBank = new TDBank(5000);
		
		DepositThread dt = new DepositThread(tdBank); // new thread is created along with this object
		WithdrawalThread wt = new WithdrawalThread(tdBank);
		CheckBalanceThread bt = new CheckBalanceThread(tdBank);
		
		dt.setName("Deposit thread");
		wt.setName("Withdrawal thread");
		bt.setName("CheckBalance thread");
		
		dt.start();
		wt.start();
		bt.start();

	}

}
