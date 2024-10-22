package service;

public class Springboot implements CourseInterface {

	public Springboot() {
		super();
		System.out.println("Springboot bean created");
	}

	@Override
	public Boolean getTheCourse(double amount) {
		System.out.println("Springboot course purchased for "+amount);
		return true;
	}
	
	
	
	

}
