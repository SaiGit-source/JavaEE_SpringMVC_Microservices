package basicDebugging;

public class ThreadExample1 extends Thread {// i extend the main class itself
	public ThreadExample1() {
		
	}
	
	public ThreadExample1(String name) {
		super(name); // we are passing thread name to the parent class Thread
	}

	public static void main(String[] args) {
		
		ThreadExample1 thread1 = new ThreadExample1("Thread1");
		ThreadExample1 thread2 = new ThreadExample1("Thread2");
		
		thread1.start();
		thread2.start();

	}
	
	// when you hit start() we execute this method
	// it prints twice
	/*
	 Threads are starting
	 Threads are starting
	 */
	
	public void run() {
		System.out.println("Threads are starting");
	}

}
