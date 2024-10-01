package Examples;
// Multi-tasking can happen both at Application-level and OS-level
// In Multithreading we are demonstrating multi-tasking at Application level
// Java is a multi-threaded language
// The default thread in Java is called as the main thread


public class Multithreading1 {

	public static void main(String[] args) throws InterruptedException {
		System.out.println("Application started....");
		Thread thread = Thread.currentThread();
		System.out.println(thread.getName()); // it says main here
		System.out.println(thread.getPriority()); // default priority is 5
		thread.sleep(4000); // 4 seconds
		thread.setName("Default main thread");
		thread.setPriority(4);
		System.out.println(thread.getName());
		System.out.println(thread.getPriority());
		System.out.println("Application terminated....");

	}

}
