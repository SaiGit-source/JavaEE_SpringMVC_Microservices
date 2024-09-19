package Examples;

public class ExceptionHandling3_CheckedException {

	public static void main(String[] args) throws InterruptedException {
		System.out.println("Main method task started");
		Thread.sleep(5000); // InterruptedException it is showing meaning Compiler is seeing a possibility of exception. also called as Checked exception
		// where-ever thread goes, those statements will get executed
		System.out.println("Main method task terminated");

	}

}
