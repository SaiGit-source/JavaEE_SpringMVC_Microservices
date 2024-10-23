package main;

import service.ICourse;

public class Udemy {
	
		private ICourse course;

		
		public Udemy(ICourse course) 
		{
			super();
			System.out.println("Constructor Injection");
			this.course = course;
		}
		
		public Udemy() 
		{
			super();
			System.out.println("Udemy Bean created");
		}

		public void setCourse(ICourse course) 
		{
			System.out.println("Setter Injection");
			this.course = course;
		}
		public Boolean buyTheCourse(Double amount)
		{
			return course.getTheCourse(amount);
		}

}
