package basic;

import java.util.PriorityQueue;

public class PriorityQueueExample {

	public static void main(String[] args) {
		// heterogeneous data
		// Queue interface FIFO
		// min-heap datastructure
		// insertion order is not maintained
		// Duplicates allowed
		// no index based insertions
		
		PriorityQueue pq = new PriorityQueue();
		pq.add(300);
		pq.add(100);
		pq.add(120);
		pq.add(50);
		pq.add(200);
		pq.add(75);
		pq.add(75);

		System.out.println(pq); // data stored in min-heap datastructure so no insertion order or sorted order when we print
		// however if you poll() it will give the minimum of the array
		// we have the poll(), peek(), offer() methods from the Queue interface	
	}

}
