package Examples;

import java.util.Scanner;

// lets say we have 3 independent activities: banking, printing, counting
// lets try to run all 3 tasks with the main thread, however, when we see something like this then there is scope for multithreading because it wastes CPU time

class Bank{
	public void banking() {
		System.out.println("Banking activity started....");
		Scanner scan = new Scanner(System.in);
		System.out.print("Enter User number: ");
		int user = scan.nextInt();
		System.out.print("Enter Password: ");
		int pwd = scan.nextInt();
		System.out.print("Continue with banking..");
		System.out.println("Banking activity terminated....");
	}
}

class PrintShop{

	public void printing() throws InterruptedException {
		System.out.println("Printing activity started....");
		for (int i=0; i<5; i++) {
			System.out.println("***");
			Thread.sleep(4000);
		}
		System.out.println("Printing activity terminated....");
	}	
}

class Counter{
	public void counting() throws InterruptedException {
		System.out.println("Counting activity started....");
		for (int i=0; i<5; i++) {
			System.out.println("Count: "+i);
			Thread.sleep(4000);
		}
		System.out.println("Counting activity terminated....");		
	}
}

public class Multithreading2 {

	public static void main(String[] args) throws InterruptedException {
		Bank b = new Bank();
		PrintShop p = new PrintShop();
		Counter c = new Counter();
		b.banking(); // banking requires IO operation, if user doesn't enter the main thread is held at this point and cant proceed to the next process
		// here CPU resource is wasted waiting for IO, even though they are independent activities
		p.printing();
		c.counting();
	}
}
