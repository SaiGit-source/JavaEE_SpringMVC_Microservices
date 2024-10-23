package service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class Udemy {
		
		@Autowired // automatic dep inj
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

		@Autowired
		@Qualifier("springBoot")
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
