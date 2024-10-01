package Examples;

import java.util.Scanner;
// in this case, we have only one run() method


class OneRun implements Runnable{

	@Override
	public void run()
	{	
		String threadName = Thread.currentThread().getName();
		if (threadName=="BANK") {
			banking();
		}
		else if (threadName=="PRINT") {
			try {
				printing();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else if (threadName == "COUNT") {
			try {
				counting();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
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
	
	public void printing() throws InterruptedException {
		System.out.println("Printing activity started....");
		for (int i=0; i<5; i++) {
			System.out.println("***");
			Thread.sleep(4000);
		}
		System.out.println("Printing activity terminated....");
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

public class RunnableWithNameExample {

	public static void main(String[] args) throws InterruptedException {
		System.out.println("Application started....");
		OneRun one = new OneRun();
		Thread thread1 = new Thread(one);
		Thread thread2 = new Thread(one);
		Thread thread3 = new Thread(one);
		
		thread1.setName("BANK");
		thread2.setName("PRINT");
		thread3.setName("COUNT");
		
		thread1.start();
		thread2.start();
		thread3.start();
		
		thread1.join();
		thread2.join();
		thread3.join();
		
		System.out.println("Application terminated....");
	}

}
