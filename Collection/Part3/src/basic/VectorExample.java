package basic;

import java.util.Enumeration;
import java.util.Iterator;
import java.util.Vector;

public class VectorExample {

	public static void main(String[] args) {
		Vector vec = new Vector();
		// Vector implements two interfaces List<> and Enumeration<>
		vec.add(100);
		vec.add(200);
		vec.addElement(300); // this method is from Enumeration<> but does the same thing
		
		Iterator itr = vec.iterator();
		while(itr.hasNext()) {
			System.out.println(itr.next());
		}
		// they both do the exact same things
		Enumeration enu = vec.elements();
		while(enu.hasMoreElements()) {
			System.out.println(enu.nextElement());
		}
		// Enumeration<> is a legacy interface

	}

}
