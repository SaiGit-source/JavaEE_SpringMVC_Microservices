package Examples;
// Multi-threading can be implemented by 1. extending the Thread class and 2. by implementing Runnable interface<>
// in this example we can extend Thread class

import java.util.Scanner;

class BankThread extends Thread{

	@Override
	public void run()
	{
		banking();
	}

	public void banking() {
		System.out.println("Banking activity started....");
		Scanner scan = new Scanner(System.in);
		System.out.print("Enter User number: ");
		int user = scan.nextInt();
		System.out.print("Enter Password: ");
		int pwd = scan.nextInt();
		System.out.println("Continue with banking..");
		System.out.println("Banking activity terminated....");
	}
}

class PrintShopThread extends Thread{
	@Override
	public void run()
	{
		try {
			printing();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void printing() throws InterruptedException {
		System.out.println("Printing activity started....");
		for (int i=0; i<5; i++) {
			System.out.println("***");
			Thread.sleep(4000);
		}
		System.out.println("Printing activity terminated....");
	}	
}

class CounterThread extends Thread{
	
	@Override
	public void run()
	{
		try {
			counting();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void counting() throws InterruptedException {
		System.out.println("Counting activity started....");
		for (int i=0; i<5; i++) {
			System.out.println("Count: "+i);
			Thread.sleep(4000);
		}
		System.out.println("Counting activity terminated....");		
	}
}


public class ThreadingExample {

	public static void main(String[] args) throws InterruptedException {
		System.out.println("Main thread: Application started...");
		BankThread b = new BankThread(); // because we are extending the Thread class, this class inherits the Thread methods(). so start() method is part of it. so when we create an object of the Bank class, thread object is created with it
		b.start();
		PrintShopThread p = new PrintShopThread();
		p.start();
		CounterThread c = new CounterThread();
		c.start(); // now if we want to 
		b.join();
		p.join();
		c.join();
		System.out.println("Main thread: Application terminated...");
		// note that this is run by the default main thread. so this runs independently of other threads so the Application starts and ends before other threads
		// the main thread can be controlled by the join() method that means main thread will have to wait until all threads are finished
		// now regardless of the IO process, other threads are being executed so CPU time is not wasted
	}

}
