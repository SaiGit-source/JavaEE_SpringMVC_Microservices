package DepInjection;

public class SpringBoot_course implements CourseInterface {

	@Override
	public Boolean buyTheCourse(int amount) {
		System.out.println("SpringBoot course is purchased for: "+amount);
		return true;
	}
	
}
