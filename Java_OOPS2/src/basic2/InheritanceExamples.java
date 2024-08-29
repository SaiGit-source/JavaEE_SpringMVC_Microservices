package basic2;
class AeroPlane { // parent class doesn't extend anything but in the background it does extend the Object class
	// thats why we are seeing Object class methods in child objects
	AeroPlane(){
		System.out.println("This is AeroPlane parent");
	}
	
	void fly() {
		System.out.println("I am flying");
	}
	
	void land() {
		System.out.println("I am landing");
	}
}

class CargoPlane extends AeroPlane{
	void layover() {
		System.out.println("Layover Cargoplane");
	}
	
	// for example here Constructor() is not present, still Super() is present in the background
	// this Super() in the child class is trigerring Constructor of parent class thats why it prints what's there in the constructor
}

class PassengerPlane extends AeroPlane { // child class extends parent class
	void layover() {
		System.out.println("Layover PassengerPlane");
	}// Layover is a specialized method that means it is not there in the parent but only in the child class
	
}


public class InheritanceExamples {

	public static void main(String[] args) {
		CargoPlane cp = new CargoPlane();
		cp.fly(); // these are inherited methods from AeroPlane class
		// if i change something in the inherited method it becomes overriden method
		cp.land(); // only methods and variables get inherited by the child class not constructor. still constructor is of parent class is being called through the super() method in the child class
		
		AeroPlane pp = new PassengerPlane(); // upcasting, we are referencing a parent class to get a child object
		pp.fly();
		((PassengerPlane) pp).layover(); // downcasting it is not directly allowed, we have to cast with child class to run child specialized method
	
	}

}
