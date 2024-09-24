package basic;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.concurrent.CopyOnWriteArrayList;

public class Iterator_FailSafeMechanism {

	public static void main(String[] args) {
		// Parent of Interfaces like List<>, Queue<>, Set<> is Collection<>
		// Parent of Collection is Iterator<>
		// Parent of all classes is Object
		// thats why we have to downcast Object into Integer or anything
		// Say the problem of Concurrent modification is not understood by for loop, even though for loop can be used to loop ArrayList
		// so it leads to memory overflow problem
		// this problem is fixed by using Iterator<> because it understands memory overflow problem and cycle problems.
		
		ArrayList al = new ArrayList();
		al.add(200);
		al.add(10);
		al.add(100);
		al.add(120);
		
		/*
		for (int i=0; i<al.size(); i++) {
			Integer data = (Integer) al.get(i); // downcasting because object is the parent
			System.out.println(data);
			al.add(44); // ArrayList is a Dynamic array so it grows dynamically as we add but for loop doesn't understand it's going to grow infinitely. This is Concurrent modification problem
		} // hence for loop is not recommended for dynamic datastructures
		*/
		
		// Fail fast mechanism
		
		/*
		Iterator itr = al.iterator();
		while (itr.hasNext()) {
			System.out.println(itr.next());
			al.add(44); // it fails with the exception: java.util.ConcurrentModificationException
			// this is called as Fail fast mechanism. Iterator knows there is a problem so it fails fast
		}
		*/
		
		// Fail safe mechanism
		
		CopyOnWriteArrayList cl = new CopyOnWriteArrayList();
		cl.add(200);
		cl.add(120);
		cl.add(100);
		Iterator itr1 = cl.iterator();
		while (itr1.hasNext()) {
			System.out.println(itr1.next());
			cl.add(44); // here it fails the loop detecting the problem but with no Exception
			// hence this is called as Fail safe mechanism
		}
		
		// reverse iteration using List iterator
		System.out.println("List Iterator");
		ListIterator litr = al.listIterator(al.size()); // instead of empty brackets we use al.size()
		while (litr.hasPrevious()) {
			System.out.println(litr.previous());
		}		
	}

}
