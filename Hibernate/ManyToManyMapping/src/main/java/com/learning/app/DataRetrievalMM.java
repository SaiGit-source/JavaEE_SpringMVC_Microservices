package com.learning.app;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.learning.model.Students;

public class DataRetrievalMM {

	public static void main(String[] args) {
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session=null;
				
		try {
			session = sessionFactory.openSession();
			// Student student = session.get(Student.class, 1); // get data of ID=1 from student table
								
			Students stu1 = session.get(Students.class, 1);
			Students stu2 = session.get(Students.class, 2);
			Students stu3 = session.get(Students.class, 3);
			
			System.out.println("St ID 1: "+stu1);
			System.out.println("St ID 2: "+stu2);
			System.out.println("St ID 3: "+stu3);
			/* for example we are getting M:M like this
			 * St ID 3: Students [id=3, city=Portland, courses=[Courses [id=2, courseName=SpringBoot, coursePrice=1000], Courses [id=3, courseName=Hibernate, coursePrice=500], Courses [id=1, courseName=Java, coursePrice=2000]]]
			 */
			
		}
		catch (HibernateException e) 
		{
			e.printStackTrace();
		}
		
		catch (Exception e1) {
			e1.printStackTrace();
		}
		
		finally {
			
			session.close();
			sessionFactory.close();
		}
	}




}
