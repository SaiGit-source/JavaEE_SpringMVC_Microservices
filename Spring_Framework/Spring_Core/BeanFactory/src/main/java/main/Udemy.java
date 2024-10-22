package main;

import service.CourseInterface;

public class Udemy {
	
	public CourseInterface iCourse;

	public Udemy(CourseInterface iCourse) {
		super();
		System.out.println("Constructor Injection");
		this.iCourse = iCourse;
	}
	
	
	// we need this zero parameter constructor because setter injection
	public Udemy() {
		super();
		System.out.println("Udemy bean created");
	}



	public CourseInterface getiCourse() {
		return iCourse;
	}

	public void setiCourse(CourseInterface iCourse) {
		this.iCourse = iCourse;
	}
	
	public Boolean buyTheCourse(double amount) {
		return iCourse.getTheCourse(amount);
	}
	
}
