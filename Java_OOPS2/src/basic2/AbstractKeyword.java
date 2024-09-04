package basic2;
abstract class AbstractParent{ // even if one method is abstract ,class must be abstract
	public abstract void method1(); // no implementation or body only signature that's why abstract 
	
	public void concreteMethod() {
		System.out.println("Parent concrete method");
	} // this is partial abstract class because not 100% abstraction achieved here. not all methods are abstract. it is only possible with Interfaces
}

class AbstractChild extends AbstractParent{
	public void method1() { // note it must have the same signature meaning same parameters and return type
		System.out.println("Child method1 implemented"); // we also remove the abstract keyword because body is there
	}
} // when all methods are implemented then we remove the word abstract from class. even if one abstract method that's inherited is not implemented then we still say abstract in class

public class AbstractKeyword {

	public static void main(String[] args) {
		AbstractChild child = new AbstractChild();
		child.method1(); // only non-abstract class can be instantiated.
		child.concreteMethod(); // only objects can be created from non-abstract classes
		// the concreteMethod is inherited as it is from Parent
	}

}
