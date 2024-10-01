package Examples;

import java.util.Scanner;
// lets implement Runnable interface<>

class BankRunnable implements Runnable{

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

class PrintRunnable implements Runnable{
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

class CounterRunnable implements Runnable{
	
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



public class RunnableExample {

	public static void main(String[] args) throws InterruptedException {
		BankRunnable b = new BankRunnable();
		PrintRunnable p = new PrintRunnable();
		CounterRunnable c = new CounterRunnable();
		// because this doesn't inherit Thread class, we have to create a Thread object
		Thread thread1 = new Thread(b);
		Thread thread2 = new Thread(p);
		Thread thread3 = new Thread(c);
		thread1.start();
		thread2.start();
		thread3.start();
		System.out.println(thread1.getName()+ " "+ thread1.isAlive());
		System.out.println(thread2.getName()+ " "+ thread2.isAlive());
		System.out.println(thread3.getName()+ " "+ thread3.isAlive());
		thread1.join();
		thread2.join();
		thread3.join();
		System.out.println("Application terminated....");
	}

}
