package basic;

import java.util.ArrayList;
import java.util.Collections;

public class SimpleSorting {
// if it is only one thing like String or Integer, Collections.sort() will work
	
	public static void main(String[] args) {
		ArrayList<Integer> al1 = new ArrayList<>();
		al1.add(300);
		al1.add(200);
		al1.add(50);
		Collections.sort(al1);
		System.out.println(al1);

		ArrayList<String> al2 = new ArrayList<>();
		al2.add("Zebra");
		al2.add("Fox");
		al2.add("Lion");
		Collections.sort(al2);
		System.out.println(al2);

		
	}

}
