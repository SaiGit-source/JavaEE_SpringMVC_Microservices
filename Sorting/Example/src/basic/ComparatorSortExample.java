package basic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

// we need Comparator<> or Comparable<> interfaces if we have more attributes
// Comparator is better if we dont have access to the target class, which we are sorting, because we are creating a separate class for sorting implementation
// 3 ways to implement interfaces: 1. implements class, 2. Anonymous inner class, 3. Labmda function
// when the class has only one method() to implement, Lambda method is the best

class Student{
	int age;
	String name;
	double score;
	
		
	public Student(int age, String name, double score) {
		super();
		this.age = age;
		this.name = name;
		this.score = score;
	}


	@Override
	public String toString() {
		return "Student [age=" + age + ", name=" + name + ", score=" + score + "]";
	}
	
}

// 1. using implements keyword
class Sorter implements Comparator<Student>{

	@Override
	public int compare(Student o1, Student o2) {
		if (o1.score > o2.score) {
			return 1; // return 1 means swap so this always sorts the target class in ascending order
		} // o2 > o1 return 1 is descending order
		else {
			return -1;
		}
	}	
}


public class ComparatorSortExample {
	

	public static void main(String[] args) {
		ArrayList<Student> al1 = new ArrayList<>();
		Student s1 = new Student(35, "First", 88.87);
		Student s2 = new Student(37, "Second", 78.87);
		Student s3 = new Student(39, "Third", 68.87);
		
		al1.add(s1);
		al1.add(s2);
		al1.add(s3);
		System.out.println("Implements keyword class");
		System.out.println("Original list: "+al1);
		
		Sorter sorter = new Sorter();
		
		Collections.sort(al1, sorter); // passing in the object of Sorter class()
		System.out.println("Sorted by score implements keyword: "+al1);
		
		// Anonymous inner class for interface<> implementation
		
		ArrayList<Student> al2 = new ArrayList<>();
		al2.add(s1);
		al2.add(s2);
		al2.add(s3);
		System.out.println("Anonymous inner class");
		System.out.println("Original list: "+al2);

		
		Comparator<Student> c1 = new Comparator<>() {
						@Override
						public int compare(Student o1, Student o2) {
							if (o1.score > o2.score) {
								return 1; // return 1 means swap so this always sorts the target class in ascending order
							} // o2 > o1 return 1 is descending order
							else {
								return -1;
							}
						}
					}; 
					
		Collections.sort(al2, c1);
		System.out.println("Sorted by score Anonymous inner class: "+al2);
					
		// Lambda method for interface implementation
		
		ArrayList<Student> al3 = new ArrayList<>();
		al3.add(s1);
		al3.add(s2);
		al3.add(s3);
		System.out.println("Lambda implementation");
		System.out.println("Original list: "+al3);

		
		Comparator<Student> c2 = (Student o1, Student o2)-> {
							if (o1.score > o2.score) {
								return 1; // return 1 means swap so this always sorts the target class in ascending order
							} // o2 > o1 return 1 is descending order
							else {
								return -1;
							}
						}; // Lambda implementation
					
		Collections.sort(al3, c2);
		System.out.println("Sorted by score Lambda: "+al3);
		
		

	}

}
