package basic;

import java.util.ArrayDeque;

public class ArrayDequeExample {

	public static void main(String[] args) {
		// Deque interface, Double-ended queue datastructure
		// order of insertion is preserved
		// no insertion at index only first and last bcos of deque
		// Duplicates allowed
		
		ArrayDeque ad = new ArrayDeque();
		ad.add("Java");
		ad.addFirst(100);
		ad.addLast(200);
		ad.add(200);
		System.out.println(ad);
	}

}
