package basic2;

interface Calc1{
	void add(int a, int b); // by default, interface methods are public and abstract
	void sub(int a, int b);
	float pi = 3.14f; // by default Interface variables are final and static 
	// it can have static methods but cannot be inherited
}

interface Calc2{
	void mul(int a, int b);
	void div(int a, int b);
	default void mod(int a, int b) { // for methods with implementation within Interface, we must use the 'default' keyword
		int res = a%b;
		System.out.println("Mod is: "+res);
	}
}

interface Calc3 extends Calc1, Calc2 { // interface can extend multiple interfaces but cannot implement them
	
} // usually a class can extend only one class but this is an interface

class MyCalc1 implements Calc1, Calc2, Calc3{
	public void add(int a, int b) { // visibility of overridden cannot be reduced so public keyword is must
		int res = a+b;
		System.out.println("Add is: "+res);
	}

	public void mul(int a, int b) {
		int res = a*b;
		System.out.println("Mul is: "+res);
		
	}

	public void div(int a, int b) {
		int res = a/b;
		System.out.println("Div is: "+res);
	}

	public void sub(int a, int b) {
		int res = a-b;
		System.out.println("Sub is: "+res);
	}
	
}

public class InterfaceExampl {

	public static void main(String[] args) {
		MyCalc1 cal1 = new MyCalc1();
		cal1.add(3, 4);
		cal1.mod(10, 5); // all methods from both Interfaces are available here
		System.out.println(Calc1.pi); // must be accessed with Interface name.variable
		
		Calc1 cal2 = new MyCalc1(); // interface cannot create an object but can be a reference variable for polymorphism
		cal2.sub(10, 5); // now cal2 has only 2 methods because of the reference interface. it doesn't know about other methods of the second interface
		
	}

}
