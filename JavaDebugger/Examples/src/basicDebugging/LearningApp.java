package basicDebugging;

public class LearningApp {

	public static void main(String[] args) {
		System.out.println("Learning App login");
		
		int a = 1;
		int b = 10;
		
		for (int i=0; i<3; i++) {
			System.out.println("Inside loop "+i); // take a look into variables as well
		} // i changes along with for loop
		
		disp(); // here StepInto will step into the disp() method
		
		System.out.println("Learning App Logged out");

	}
	
	public static void disp() {
		System.out.println("Disp() method");
	}

}
