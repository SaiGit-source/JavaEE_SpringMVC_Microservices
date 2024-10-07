package basicDebugging;

public class ThreadExample2 implements Runnable { // we are implementing Runnable in the main class itself

	public static void main(String[] args) {
		ThreadExample2 t = new ThreadExample2();
		Thread t1 = new Thread(t); // this will use run method of this class ThreadExample2
		t1.start();
		
		Thread t2 = new Thread(()->System.out.println("I am a thread from a diff class")); // only one method is there that's run method so lambda works here
		t2.start();

	}

	@Override
	public void run() {
		System.out.println("Default run method");
		
	}

}
