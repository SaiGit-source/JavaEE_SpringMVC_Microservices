package basic;

import java.util.ArrayList;

public class ArrayListExample {

	public static void main(String[] args) {
		// ArrayList -> any data type can be added because it takes only objects
		// Duplicates Yes
		// Insertion at index Yes
		// List interface, dynamic array datastructure
		// insertion order maintained
		
		ArrayList al = new ArrayList();
		al.add(10);
		al.add("Java");
		al.add(30.230);
		al.add(false);
		al.add(0, 100); // insert at 0 index 
		al.add(3,100);
		
		ArrayList al2 = new ArrayList();
		al2.addAll(al); // add another arrayList
		System.out.println(al2);
		System.out.println(al2.contains("Java"));
		System.out.println(al2.containsAll(al));

	}

}
