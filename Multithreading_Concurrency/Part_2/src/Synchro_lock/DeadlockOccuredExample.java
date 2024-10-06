package Synchro_lock;

// Deadlock is a condition where we have cyclic dependency of resources by threads
// Multiple threads are in blocked state
// So they are locked in that state forever
// Deadlocks can be resolved by proper use of synchronized keyword

/* this is Deadlock scenario - incorrect use of synchronized keyword
 */

class Library implements Runnable{
	// 
	String res1 = new String("Java");
	String res2 = new String("SpringBoot");
	String res3 = new String("DSA");

	@Override
	public void run() {
		try {
		String threadName = Thread.currentThread().getName();
		if (threadName=="Student1") {
			System.out.println(threadName + " enters library");
			Thread.sleep(2000); // i put res in reverse order
			synchronized(res1) // locks res1 until following block is executed, which is Java book
			{
				System.out.println(threadName + " acquired " + res1);
				Thread.sleep(2000);
				synchronized(res2) {					
					System.out.println(threadName + " acquired " + res2);
					Thread.sleep(2000);
				
				synchronized(res3) {					
					System.out.println(threadName + " acquired " + res3);
					Thread.sleep(2000);
				}
				}
			} 
		}
		
			
		else if (threadName=="Student2") {
			System.out.println(threadName + " enters library");		
			synchronized(res3) // locks res1 until following block is executed, which is Java book
			{
				System.out.println(threadName + " acquired " + res3);
				Thread.sleep(2000);
				synchronized(res2) {					
					System.out.println(threadName + " acquired " + res2);
					Thread.sleep(2000);
				
				synchronized(res1) {					
					System.out.println(threadName + " acquired " + res1);
					Thread.sleep(2000);
				}
				}
			} 
		}
	}
	catch (InterruptedException e) {
		e.printStackTrace();
	}
			
	}
		
}
	

public class DeadlockOccuredExample {

	public static void main(String[] args) {
		Library lib = new Library();
		
		Thread t1 = new Thread(lib);
		Thread t2 = new Thread(lib);
		
		t1.setName("Student1");
		t2.setName("Student2");
		
		t1.start();
		t2.start();

	}

}
