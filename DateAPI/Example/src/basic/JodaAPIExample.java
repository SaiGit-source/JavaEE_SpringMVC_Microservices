package basic;
// recommended dateAPI package is time package from JODA API

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class JodaAPIExample {

	public static void main(String[] args) {
		System.out.println("LocalDate.now");
		LocalDate date = LocalDate.now(); // static methods are accessed through class.method()
		System.out.println("Day of month: " + date.getDayOfMonth() + " Day of year: "+ date.getDayOfYear());
		
		System.out.println("Today's date is: " + date.getDayOfMonth() + " " + date.getMonth() + " " + date.getYear());
		
		System.out.println("LocalDate.of");
		LocalDate dob = LocalDate.of(1993, 6, 25);
		System.out.println(dob);
		
		System.out.println("LocalTime.now");
		LocalTime time1 = LocalTime.now(); //no 'new' keyword because it is a static method
		System.out.println(time1.getHour()+" hour "+time1.getMinute()+" minute "+ time1.getSecond()+" seconds");
		
		System.out.println("LocalDateTime");
		LocalDateTime dt = LocalDateTime.now();
		
		System.out.println("LocalDateTime: "+dt);
		

	}

}
