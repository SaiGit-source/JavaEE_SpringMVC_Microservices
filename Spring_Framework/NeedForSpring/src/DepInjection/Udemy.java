package DepInjection;

// public class Udemy extends Java_course{ // inheritance makes it tightly coupled
public class Udemy{
		
	// i want to use buyTheCourse() method from Java_course class inside the Udemy class
	// public Boolean getTheCourseFromUdemy(int amount) {
		// we want to use buyTheCourse() method
		// Option 1: Composition, create a Java object
		//Java_course java = new Java_course(); // 
		// return java.buyTheCourse(amount);
		
		//Option 2: is Inheritance by using extends keyword Udemy extends Java
		// return buyTheCourse(amount); // i am directly using the inherited method 
		// both these options are not good because they tightly couple both classes
		
		// Option 3: Polymorphism
		// we create an interface and use the parent interface to inject/pass the objects in
		
	// }
	
	// Option 3:
	// i create a parent or interface variable here
	CourseInterface courseInterface;
	
	// then i do constructor injection or setter injection and set the variable to the memory address of child object (Java or SpringBoot)
	// then in the getTheCourseFromUdemy() method, i call another class method (Java) inside this class without creating an object of this class
	
	// constructor injection
	public Udemy(CourseInterface courseInterface) {
		super();
		this.courseInterface = courseInterface;
	}
	
	// setter injection
	public CourseInterface getCourseInterface() {
		return courseInterface;
	}

	public void setCourseInterface(CourseInterface courseInterface) {
		this.courseInterface = courseInterface;
	}
	// Udemy class will determine the amount for each course
	// then we pass the amount into the individual course class
	public Boolean getTheCourseFromUdemy(int amount) {
		
		return courseInterface.buyTheCourse(amount);
	}
	

}



