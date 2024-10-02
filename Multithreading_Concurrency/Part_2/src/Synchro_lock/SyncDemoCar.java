package Synchro_lock;

class MyCar implements Runnable{
	
	// states of thread: 
	// New() - when we create a thread
	// Runnable - waiting to be scheduled that means it can be Runnable
	// Running - only one thread can run at a time. so whichever thread is in the run() method
	// Dead - once task is over, it will go to dead state
	// Blocked - if resources are not available for a thread it waits in Blocked state. run() method could be blocked due to that

	@Override
	public void run() { // instead of using synch here
		try {
			System.out.println(Thread.currentThread().getName() + " entering parking lot"); // all drivers can enter parking lot so we dont need to synch here
			Thread.sleep(2000);
			
			synchronized(this) // synchronization will happen from this point
			{ 
			System.out.println(Thread.currentThread().getName() + " entering car");
			Thread.sleep(2000);
			System.out.println(Thread.currentThread().getName() + " driving car");
			Thread.sleep(2000);
			System.out.println(Thread.currentThread().getName() + " parking car");
			Thread.sleep(2000);
			}
		} 
		
		catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}
	
}

public class SyncDemoCar {

	public static void main(String[] args) {
		MyCar car = new MyCar();
		
		Thread t1 = new Thread(car);
		Thread t2 = new Thread(car);
		Thread t3 = new Thread(car);
		
		t1.setName("DriverA");
		t2.setName("DriverB");
		t3.setName("DriverC");
		
		t1.start();
		t2.start();
		t3.start();
	}

}
