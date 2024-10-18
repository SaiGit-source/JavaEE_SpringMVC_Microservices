package DepInjection;

// Dependency injection revision - next we will see how to do it with Spring core

public class DepInjection_Main_IOC {
	// the idea is we want to achieve loose coupling between classes so if one class goes down other remains unaffected
	// Udemy class wants to use methods from Java class and SpringBoot class. but how to do it without creating objects of these classes inside Udemy class? thats where Dep inj comes into pic
	// two ways are possible: Composition and Inheritance both will result in tight coupling, which we want to avoid
	// here we provide Inversion of control of creating object to main() method. instead of Udemy class creating objects
	// In Spring framework, we provide inversion of control of creating objects to Spring
	// Also we will hand-over dependency injection to Spring framework

	public static void main(String[] args) {
		Java_course java = new Java_course(); // i invert the control of creating a new object to the main() method
		Udemy udemy = new Udemy(java); // Constructor injection first
		udemy.getTheCourseFromUdemy(1000);
		// dependent class object is java and the target class is udemy. we are injecting dependent object into target that's dependency injection
		
		// setter injection
		SpringBoot_course springBoot = new SpringBoot_course();
		udemy.setCourseInterface(springBoot);
		udemy.getTheCourseFromUdemy(500);

	}

}
