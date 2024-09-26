package basic;

// import java.sql.Date;

import java.util.Date;

// two packages available to import Date class: util and sql packages
// the recommended one is Date class from time package from JODA API (>Java8)

public class OldDateAPIs {

	public static void main(String[] args) {
		Date date1 = new Date(); // from util package, instance methods() so we create an object
		System.out.println("Year from util: "+date1.getYear()); // deprecated method
		System.out.println("Time from util: "+date1.getTime()); 
		
		// Date date2 = new Date();
		

	}

}
