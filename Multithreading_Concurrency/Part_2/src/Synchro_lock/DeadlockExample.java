package Synchro_lock;

// Deadlock is a condition where we have cyclic dependency of resources by threads
// Multiple threads are in blocked state
// So they are locked in that state forever
// Deadlocks can be resolved by proper use of synchronized keyword

/* this is Deadlock avoidance scenario - correct way of using sync keyword
	Student2 enters library
	Student1 enters library
	Student2 acquired Java
	Student2 acquired SpringBoot
	Student2 acquired DSA // until Java lock is released next student1 cannot acquire locks so this thread will be in Blocked state waiting for resources
	Student1 acquired Java
	Student1 acquired SpringBoot
	Student1 acquired DSA
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
			Thread.sleep(2000);
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
	}
	catch (InterruptedException e) {
		e.printStackTrace();
	}
			
	}
		
}
	

public class DeadlockExample {

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
