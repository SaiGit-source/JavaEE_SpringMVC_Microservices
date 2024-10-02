package Synchro_lock;

// Daemon thread is a background process where it follows the main thread closely but will make sure it will get executed in the end. so it will run as an infinite loop but wont get executed infinite times because it is a Daemon thread
// Garbage collector is an example of Daemon thread, it will make sure it gets executed once in the end to clean up
// usually it takes a priority lower than main thread
// the application is where we have three methods(): typing, spellchecking, autosaving. it needs to happen in a sequence. for example, checking cannot happen while typing. otherwise race condition could occur

class MSWord extends Thread{ // we are extending the Thread class here
	
	@Override
	public void run() {
		String threadName = Thread.currentThread().getName();
		if (threadName.equals("TYPE")) {
			typing();
		}
		else if (threadName.equals("SPELL")) {
			spellchecking();
		}
		else if (threadName.equals("SAVE")) {
			autosaving();
		}
		
	}
	
	public void typing() {
		try {
		for (int i=0; i<4; i++) {
			
				System.out.println("Typing...");
				Thread.sleep(3000);
			}
		}
		catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	
	public void spellchecking() {
		
		/*
		for (int i=0; i<4; i++) {
			try {
				System.out.println("Spellchecking...");
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		*/
		
		// we put the same code into infinite loop
		try {
		for (;;) {
		
				System.out.println("Spellchecking...");
				Thread.sleep(3000);
			}
		}
		catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	
	public void autosaving() {
		/*
		for (int i=0; i<4; i++) {
			try {
				System.out.println("Autosaving...");
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		*/
		
		// we put the same code into infinite loop
		try {
		for (;;) {

				System.out.println("Autosaving...");
				Thread.sleep(3000);
			}
		}
		catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

public class DaemonExample {

	public static void main(String[] args) {
		// here we create 3 objects so threads are created along with them
		MSWord ms1 = new MSWord();
		MSWord ms2 = new MSWord();
		MSWord ms3 = new MSWord();
		
		ms1.setName("TYPE");
		ms2.setName("SPELL");
		ms3.setName("SAVE");
		
		ms2.setDaemon(true); // we set this to follow main thread
		ms3.setDaemon(true);
		
		ms2.setPriority(4); // we set priority lower than main thread. default is 5
		ms3.setPriority(3);
				
		ms1.start();
		ms2.start();
		ms3.start();
		
	}

}
