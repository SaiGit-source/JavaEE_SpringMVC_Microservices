package basic;

import java.util.TreeSet;

public class TreeSetExample {

	public static void main(String[] args) {
		// always prints in sorted order because of binary search tree datastructure
		// doesn't allow duplicates due to Set() interface (implements child of set interface, which is navigable set)
		// insertion at index is not allowed
		// insertion order not maintained only sorted order
		// duplicates not allowed
		
		TreeSet ts = new TreeSet();
		ts.add(400);
		ts.add(25);
		ts.add(50);
		ts.add(250);
		ts.add(100);
		ts.add(75);
		ts.add(75); // duplicates not allowed
		System.out.println(ts);// inorder traversal of binary search tree gives sorted order not insertion order
		
		System.out.println(ts.ceiling(50)); // first looks for 50 otherwise nearest higher value
		System.out.println(ts.higher(50)); // always higher than 50 no matter what
		System.out.println(ts.tailSet(100)); // all items after 100
		System.out.println(ts.headSet(100)); // all items before 100

	}

}
