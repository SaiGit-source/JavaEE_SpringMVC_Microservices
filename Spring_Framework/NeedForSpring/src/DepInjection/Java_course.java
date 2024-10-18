package DepInjection;

// public class Java_course{
public class Java_course implements CourseInterface{
	
	@Override
	public Boolean buyTheCourse (int amount) {
		System.out.println("Java course is purchased for: "+amount);
		return true;
	}


}
