package basic2;
// Runtime polymorphism can be achieved only if we have parent reference for child objects and method-overriding in child classes
class Animal{
	public void eating() {
		System.out.println("Animal is eating");
	}
	
	public void running() {
		System.out.println("Animal is eating");
	}
}


class Tiger extends Animal{
	public void eating() {
		System.out.println("Tiger is eating");
	}
	
	public void running() {
		System.out.println("Tiger is eating");
	}
}



class Monkey extends Animal{
	public void eating() {
		System.out.println("Monkey is eating");
	}
	
	public void running() {
		System.out.println("Monkey is eating");
	}
}

class Forest{
	public void living(Animal animal) {
		animal.running(); // common method call works for any child objects
		animal.eating(); 
		
		// same lines of codes exhibiting different behavoirs based on the passed-in child objects this is runtime polymorphism
	}
}

public class RuntimePolymorphism {

	public static void main(String[] args) {
		
		Animal tiger = new Tiger(); // parent reference is pointing to Tiger child object in memory
		Animal monkey = new Monkey(); // same parent ref is pointing to a diff child object memory
		
		Forest f = new Forest(); 
		f.living(tiger); // we are achieving runtime polymorphism using a common class that has a method to take the same parent ref
		f.living(monkey);


	}

}
