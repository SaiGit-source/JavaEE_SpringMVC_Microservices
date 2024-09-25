package basic;
// here we illustrate Generics in inheritance

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.TreeSet;

class Human{
	int age;
	
	public void disp() {
		System.out.println("This is Human parent");
	}
}

class Student extends Human{

	public void disp() {
		System.out.println("This is Student child");
	}
}

public class GenericsExample3 {
	
	public static void invokeDisp(List<? extends Human> list) { // upperbound is Human class so any child upto Human objects are accepted in this method
		for (Human s:list) {
			System.out.println(s); 
		}
	}

	public static void main(String[] args) {
		Human h1 = new Human();
		Student s1 = new Student();
		h1=s1; // this is ok, child is being assigned to parent reference
		
		// but it is not ok in ArrayList
		
		ArrayList<Human> hl = new ArrayList<Human>();
		hl.add(new Human());
		
		ArrayList<Student> sl = new ArrayList<Student>();
		sl.add(new Student());
		
		// hl = sl; // not possible
		ArrayList<?> hl1 = new ArrayList<>(); //? wildcard anything can be assigned now
		hl1 = sl;
		
		ArrayList<? extends Human> hl2 = new ArrayList<>();
		hl2 = sl; // here also it is ok, Human class is the upperbound so we cannot assign ArrayList<Object> because Object class is the Parent of Human class
		
		ArrayList<? super Human> hl3 = new ArrayList<>(); // here lowerbound is Human and upperbound is Object
		// hl3 = sl; // here we cannot assign ArrayList<Student> because it is a child of Human
		hl3 = new ArrayList<Object>(); // this is fine though
		
		invokeDisp(sl); // sl is also ok
		invokeDisp(hl); // hl is also ok ArrayList<Human>
		// invokeDisp(hl3); // not ok because upperbound is Object
		
		
		// one more concept w.r.t ArrayList
		List<Integer> l1 = Arrays.asList(10, 20, 30, 40);// this also works
		

	}
	
	public static Iterable<Integer> getIntegers() {
		// return new TreeSet<Integer>();
		return new ArrayList<Integer>(); // because the returnType is parent Iterator i can return any child class object of this parent
	}
	
	public static List<Integer> getInteger() {
		return new LinkedList<Integer>(); // here i can return only child class that implements List<> interface not anything else
		// return new TreeSet<Integer>(); // this doesn't implement List<> interface so cant return this type
		// return new ArrayList<Integer>(); // this is ok here
	}

}
