package lambda;

import lambda.Person1.Phone;
import lambda.Person1.Phone.Email;

// Lambda expressions shortens the code

abstract class Calc {
	abstract int add(int a, int b);
}
@FunctionalInterface // Functional interface can take only one method
interface Person {
	void getName(String s);
}

class Person1{
	int a;
	static class Phone{
		public void phone() {
			System.out.println("This is person's phone");
	}
		
	class Email{
			public void email() {
				System.out.println("This is person's email");
		}
	}
}
}
/**
* This is example Java documentation 
*/
public class LambdaExample {

	public static void main(String[] args) {
		Phone per = new Person1.Phone(); // now i can access this class only through Person1 and only if it is static
		Email per1 = per.new Email(); // now i can access non-static methods by this way only and this class is restricted to only Person1 class
		per1.email();
		
		//normally we cannot create an object directly from an interface or abstract class but possible only with Anonymous inner class if it has to be used only once
		
		Calc calc = new Calc() {
			public int add(int a, int b) {
				return a+b;
			}
		}; // Anonymous inner class has the implementation for that abstract method
		
		System.out.println(calc.add(20, 10));
		
		Person P = new Person() {
			public void getName(String s) {
				System.out.println("Name of person is "+s);
			}
		};
		
		P.getName("Anonymous inner method");
		
		Person P1 = (s) -> System.out.println("Name of person is "+s); // Now we have shrunk Anonymous method into Lambda expression it does the same thing
		P1.getName("Lambda expression");
	}

}
