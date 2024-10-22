package main;

import service.CourseInterface;

public class Udemy {
	
	CourseInterface iCourse;

	public Udemy(CourseInterface iCourse) {
		super();
		this.iCourse = iCourse;
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
