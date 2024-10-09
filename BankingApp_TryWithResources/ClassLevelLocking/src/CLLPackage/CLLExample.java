package CLLPackage;

//to demonstrate class level locking, we got to convert all methods and variables into static so we can access them from class level like className.method()
//if locking is applied to class level, then another thread cannot run any objects of the same class. but in Object level locking, another thread can run another object of the same class. that's the difference
// in this case, when i step-over to Deposit Thread into synchronized static public void deposit. when control is in synchronized static public void deposit, it says owns: Class<T>(CLLPackage.BOAbank)(id=20)
// at the same time, when i run CheckBalance thread, it says Stepping even though we are passing a different object boa2 in fact. this is the concept of Class Level Locking
// while a thread with a different object like boa2 would have continued in Object Level Locking

// put breakpoints at all thread run() methods - only then we will see different threads in the debug pane
// put breakpoints at synchronized methods for example synchronized static public void deposit

public class CLLExample {

	public static void main(String[] args) {
		
		// Constructor injection here because we are creating an object of bank class and injecting into different thread methods()
		
		BOAbank boa1 = new BOAbank();
		BOAbank boa2 = new BOAbank();
		
		DepositThread dt = new DepositThread(boa1); // new thread is created along with this object
		WithdrawalThread wt = new WithdrawalThread(boa1);
		CheckBalanceThread bt = new CheckBalanceThread(boa2); // here we are passing a different object of the same class still in CLL, i cannot proceed
		
		dt.setName("Deposit thread");
		wt.setName("Withdrawal thread");
		bt.setName("CheckBalance thread");
		
		dt.start();
		wt.start();
		bt.start();

	}

}
