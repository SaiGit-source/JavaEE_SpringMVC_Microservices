package Exercise;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

// whenever you want to work with the data in a Collection without affecting existing data: Streams come into picture

public class ForEachLoop {

	public static void main(String[] args) {
		List<Integer> list = new ArrayList<>();
		
		// we are adding some values into Collection
		
		list.add(44);
		list.add(4);
		list.add(50);
		list.add(100);
		
		System.out.println(list);

		System.out.println("*****************");
		System.out.println("Enhanced for loop");
		for (Integer i : list) {
			System.out.println(i);
		}
		
		Consumer<Integer> consumer = new Consumer<>() {// Anonymous implementation

			@Override
			public void accept(Integer n) { // implementation is specified here
				System.out.println(n);
				
			}
			
		};
		
		System.out.println("*****************");
		System.out.println("Consumer in forEach loop lengthy implementation");
		list.forEach(consumer); // consumer giving implementation for forEach
		
		System.out.println("*****************");
		System.out.println("Consumer in forEach Lambda");
		Consumer<Integer> con = (Integer n)->System.out.println(n); // lambda expression
		list.forEach(con); // con is giving the implementation for forEach
		
		
		System.out.println("*****************");
		System.out.println("ForEach loop lambda");
		list.forEach((n)->System.out.println(n));
		
				
	}

}
