package basics;

import java.util.Arrays;

class School{
	String courseName;
	int courseFees;
	String city;
	
	public School(String cn, int cf, String ci ) {
		courseName = cn;
		courseFees = cf;
		city = ci;
	}
	
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	public int getCourseFees() {
		return courseFees;
	}
	public void setCourseFees(int courseFees) {
		this.courseFees = courseFees;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	
	@Override // without overriding if we print just this class object, it will print the address.
	// it is accessing the toString() method by default
	public String toString() {
		return "School [courseName=" + courseName + ", courseFees=" + courseFees + ", city=" + city + ", toString()="
				+ super.toString() + "]";
	}
}

public class ArraysII {

	public static void main(String[] args) {
		int[][] ar = {{3,4,6},{2,4,7}}; //2D array
		
		for (int row[]:ar) {
			for(int elem : row) {
				System.out.print(elem+" ");
			}
			System.out.println();
		} // limitation of enhanced for loop is that we dont have much control. for eg: i<ar.length-2 etc		
		
		School school = new School("Java", 300, "Bangalore");
		System.out.println(school);
		
		// it prints this by default even though we haven't invoked the toString() method
		// School [courseName=Java, courseFees=300, city=Bangalore, toString()=basics.School@617c74e5]
		
		// illustrating Arrays class
		
		int[] arr = {3,2,1};
		Arrays.sort(arr); // here Arrays is a utility class because we cannot perform any operations on the data stored in Array directly.
		// Arrays.sort() = Class.method() because these methods are static methods, we are not creating an object of Arrays class to call these methods like sort()
		for (int elem:arr) {			
			System.out.print(elem+" ");
		}
	}

	

}
