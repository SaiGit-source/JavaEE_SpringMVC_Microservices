package service;

public class Java implements CourseInterface {
	
	public Java() {
		super();
		System.out.println("Java bean created");
	}

	@Override
	public Boolean getTheCourse(double amount) {
		System.out.println("Java course purchased for "+amount);
		return true;
	}

}
