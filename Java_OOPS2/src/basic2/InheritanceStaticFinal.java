package basic2;
class Parent{
	static void disp() {
		System.out.println("I am parent");
	}
}


class Child extends Parent{
	static void disp() {
		System.out.println("I am child"); // static methods can be inherited but not overrided thats called as method hiding
	}
}


class Plane{
	void disp() {
		System.out.println("I am the parent plane");
	}
	
	final void fly() {
		System.out.println("Parent plane flying");
	}
	
	void landing(String land) {
		System.out.println("Parent plane landing");
	}
}

class FighterPlane extends Plane{
	void landing() {
		System.out.println("Child specialized class landing");
	}
	
	//void fly() {
		// we cannot override a final method
	// }
	
	void disp() {
		System.out.println("I am the Child plane");
	}
}

public class InheritanceStaticFinal {

	public static void main(String[] args) {
		FighterPlane fp = new FighterPlane();
		fp.landing(); // landing is not overriden by Child class it is treated like method overloading since the parameters are different.
		fp.landing("ABC"); // printed the method inherited from parent
		
		System.out.println("Parent ref but child ob non-static method");		
		Plane fp1 = new FighterPlane();
		fp1.disp(); // here non-static method so overriden and says child message
		
		System.out.println();
		
		System.out.println("Parent ref but child ob static method displays parent message");		
		Parent ch = new Child();
		ch.disp(); // here static method is inherited but not overrided
		// here static method so displays parent method
		
		Child ch1 = new Child();
		ch1.disp(); // here no overriding again, it is treated like specialized method - method hiding
		
		fp.fly(); // final methods can be inherited but not overrided
		// final variables are treated like constants cannot be changed
		
	}

}
