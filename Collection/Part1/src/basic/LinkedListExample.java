package basic;

import java.util.LinkedList;

public class LinkedListExample {

	public static void main(String[] args) {
		// heterogenous data allowed
		// implements List and Deque interfaces
		// Double-linkedList datastructure
		// insertion at any point
		// Duplicates yes
		
		LinkedList ll = new LinkedList();
		ll.add(200);
		ll.add("Java");
		ll.add(0, false);
		ll.offer("Springboot"); // we are offering something it's up to the datastructure to accept or reject data. there is no guarantee in Offer() method, but add() method guarantees addition of data
		ll.peek();
		ll.addLast("JUnit");
		ll.addFirst("JUnit");
		System.out.println(ll); // insertion order is maintained
		System.out.println(ll.poll());
	
	}

}
