package Examples;

// synchronized public void run() is used to make sure threads dont compete and endup in race condition - it locks with one thread while running
// race condition is when threads compete to finish the task. lets say we have only one car object, all threads cannot run concurrently. 
// in multi-threading, we achieve only concurrency not parallelism. Concurrency is only one thread executes at a time but it switches threads in milliseconds thereby minimizing CPU waste
// StringBuffer() class allows multi-threading but allows only one thread to run at a time to prevent race condition - thread safety is ensured - that means all methods are synchronized
// StringBuilder class allows multi-threading but no thread safety is ensured

class myCar implements Runnable {

	synchronized public void run() {
		try {
		System.out.println(Thread.currentThread().getName()+" entering parking lot");
		Thread.sleep(2000);
		System.out.println(Thread.currentThread().getName()+" entering car");
		Thread.sleep(2000);
		System.out.println(Thread.currentThread().getName()+" driving car");
		Thread.sleep(2000);
		System.out.println(Thread.currentThread().getName()+" parking car");
		Thread.sleep(2000);
		} 
		
		catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}


}

public class SynchronizedExample {

	public static void main(String[] args) {
		myCar car = new myCar();
		Thread thread1 = new Thread(car);
		Thread thread2 = new Thread(car);
		Thread thread3 = new Thread(car);
		
		thread1.setName("ABC"); // now we have 3 drivers going to drive the same car
		thread2.setName("PQR");
		thread3.setName("XYZ");
		
		thread1.start();
		thread2.start();
		thread3.start();

	}

}
