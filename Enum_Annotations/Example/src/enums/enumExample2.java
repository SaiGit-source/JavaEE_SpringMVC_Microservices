package enums;

enum Result{
	PASS, FAIL, NR;
	// behind the scene, an object of ENUM is getting created
	// public final static enum PASS = new Result();
	int marks;
	
	Result() {
		System.out.println("Inside Result Constructor"); // whenever an instance of the object is being called, we invoke Constructor automatically
	}
	
	public void setMarks(int marks) {
		this.marks = marks;
	}
	
	public int getMarks() {
		return marks;
	}
	
}

public class enumExample2 {

	public static void main(String[] args) {
		Result.PASS.setMarks(44); // 3 times this is printed: 'Inside Result Constructor' thats because 3 enum objects are being created
		// whenever we create an instance, it executed the Constructor code
		System.out.println("Get PASS mark: "+Result.PASS.getMarks());
		
		System.out.println("Get FAIL mark: "+Result.FAIL.getMarks());
		// the default value is 0 because it is an instance variable

	}

}
