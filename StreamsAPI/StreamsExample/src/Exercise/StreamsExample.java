package Exercise;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

// i want to sort a list of data but i dont want to affect the original list. then we need Streams. it creates a new stream of data

public class StreamsExample {

	public static void main(String[] args) {
		
		List<Integer>list = new ArrayList<>();
		list.add(50);
		list.add(44);
		list.add(38);
		list.add(4);
		list.add(8);
		
		// Collections.sort(list); // see Collections will affect the original list
		// System.out.println(list);
		
		Stream<Integer> streamData1 = list.stream(); // returns Stream object
		Stream<Integer> sortedStream = streamData1.sorted(); // creates a new stream of sorted data
		// we can only perform one operation of a stream otherwise will throw an exception
		System.out.println("Sorted stream data");
		sortedStream.forEach(n->System.out.println(n)); // we have sorted the list without affecting the original list
		System.out.println("ForEach Original list");
		list.forEach(n->System.out.println(n));
		
		System.out.println("Streams with mapper");
		Stream<Integer> streamData2 = list.stream(); // returns Stream object
		Stream<Integer> sortedStream2 = streamData2.sorted(); // creates a new stream of sorted data
		Stream<Integer> streamData3 = sortedStream2.map(n->n*2);
		streamData3.forEach(n->System.out.println(n));
		
		// the other option to write the same syntax is
		
		System.out.println("Concise Stream systax");
		list.stream().sorted().map(n->n*2).forEach(n->System.out.println(n)); // here each time it creates a new stream
		
		// Another example
		
		String str = "SpringBoot";
		
		int length = str.toLowerCase().toUpperCase().concat("Java").length();
		
		// converting List into Set
		
		List<String> lst = new ArrayList<>();
		lst.add("Java");
		lst.add("SpringBoot");
		lst.add("JUnit5");
		
		Set<String> set = lst.stream().collect(Collectors.toSet());
		System.out.println("Stream to Set unsorted: "+lst);
		
		// converting stream back to List
		
		List<String> list2 = lst.stream().sorted().collect(Collectors.toList());
		System.out.println("Sorted Stream back to List: "+list2);
		
	}

}
