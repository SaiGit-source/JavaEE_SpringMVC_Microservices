package basic;

import java.util.ArrayList;

class Employee{
	int id;
	String name;
	String city;
	
	public Employee(int id, String name, String city) {
		this.id = id;
		this.name = name;
		this.city = city;
	}
	
	public String toString() {
		return "Employee id="+id+" name="+name+" City="+city; // overriding toString() method to print
	}
}


public class GenericsExample1 {
	
	// say int[] has type safety, meaning we are certain about retrieving data from int[]. it will be obviously integers
	// but there is no typesafety in Collections like ArrayList()
	// Generic ensure there is type-safety in Collections Eg. ArrayList<Integer> al = new ArrayList(). now we are certain about datatype we are retrieving from ArrayList

	public static void main(String[] args) {
		int[] ar = new int[3]; // provides type-safety
		
		ArrayList al = new ArrayList();
		al.add("Java");
		al.add(44);
		//String s1 = (String) al.get(1);
		// System.out.println(s1.toLowerCase()); // now this will throw an exception java.lang.ClassCastException no Type-safety
		// we perform String operations on Integer
		
		ArrayList<Employee> el = new ArrayList<>();
		el.add(new Employee(1234, "Abc", "Charlotte"));
		el.add(new Employee(4321, "Springboot", "Raleigh"));
		System.out.println(el); // toString() method printing
		// it will take only Employee class objects - type-safety using Generics
	}

}
