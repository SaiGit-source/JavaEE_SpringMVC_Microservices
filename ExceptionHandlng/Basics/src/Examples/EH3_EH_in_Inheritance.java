package Examples;

import java.io.IOException;

// IOException is a Checked exception meaning, Compiler foresees possibility of exception during Runtime. Complier checks for the exception thats why Checked exception
// ArithmeticException is an example of Unchecked exception meaning, Compiler doesn't look for it instead it happens during Runtime
// Partial exception in Child is not allowed as well, meaning one Child throws Unchecked and other throws Checked (if Checked not thrown by Parent)

class Parent{
	public void work() throws IOException {
		System.out.println("Parent is working");
	}
}


class Child1 extends Parent{
	public void work() throws IOException { //IOException is a Checked exception and we cannot have it only at the Child overridden method() unless the Parent method() throws the same Checked exception
		// Exception IOException is not compatible with throws clause in Parent.work()
		System.out.println("Child1 is working");
	}
}


class Child2 extends Parent{
	public void work() throws ArithmeticException { // however a Child method() can throw Unchecked exception regardless of whether Parent throws or not
		System.out.println("Child2 is working");
	}
}

public class EH3_EH_in_Inheritance {

	public static void main(String[] args) throws IOException {// for Checked we got to add throws in main() method also
		Parent par = new Parent();
		par.work();
		Child2 chi = new Child2();
		chi.work();

	}
}
