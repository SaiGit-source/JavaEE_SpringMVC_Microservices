package basic;

import java.util.HashSet;
import java.util.LinkedHashSet;

public class SetExample {

	public static void main(String[] args) {
		// HashSet() -> implements Set<> interface
		// hashing function so searching in O(1)
		// No duplicates because of Set family
		// No sorting, 
		// load factor=0.75 meaning when 75% of locations filled it doubles its capacity
		// TreeSet skewed binary search tree will take O(n) for searching this problem is overcome in HashSet()
		
		HashSet hs = new HashSet<>();
		hs.add(30);
		hs.add(40);
		hs.add(100);
		hs.add(120);
		hs.add(200);
		System.out.println(hs); // insertion order NOT maintained
		
		LinkedHashSet ls = new LinkedHashSet<>();
		ls.add(40);
		ls.add(100);
		ls.add(120);
		ls.add(200);
		ls.add(300);
		System.out.println(ls); // insertion order maintained
		
	}

}
