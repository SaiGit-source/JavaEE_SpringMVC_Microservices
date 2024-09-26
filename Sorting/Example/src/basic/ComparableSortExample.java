package basic;

import java.util.ArrayList;
import java.util.Collections;

// this is simpler than Comparator but what if we dont have access to the Target class to modify
// here we are adding one method compareTo() into the Target class

class Player implements Comparable<Player>{
	int age;
	String name;
	double avg;
	
	public Player(int age, String name, double avg) {
		super();
		this.age=age;
		this.name=name;
		this.avg=avg;
	}
	
	@Override
	public String toString() {
		return "Player [age=" + age + ", name=" + name + ", avg=" + avg + "]";
	}

	@Override
	public int compareTo(Player o) {
		if (this.avg > o.avg) {
			return 1; // again sorting in ascending order by avg
		}
		else {
			return -1;
		}
	}
	
}

public class ComparableSortExample {

	public static void main(String[] args) {
		ArrayList<Player> al1 = new ArrayList<>();
		Player pl1 = new Player(34, "First", 88.45);
		Player pl2 = new Player(36, "Second", 78.45);
		Player pl3 = new Player(38, "Third", 68.45);
		
		al1.add(pl1);
		al1.add(pl2);
		al1.add(pl3);
		
		System.out.println("Original list: "+al1);
		Collections.sort(al1); // takes only one parameter, unlike the other interface
		System.out.println("Sorted list by Comparable: "+al1);
	}

}
