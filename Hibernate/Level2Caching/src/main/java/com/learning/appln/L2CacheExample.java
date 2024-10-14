package com.learning.appln;


import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.learning.model.Student;

// Level 1 is at session level and each session object will have a L1 cache memory

// Level 2 cache is the cache memory at factory level. i want to have one common memory for the entire application that will work for session 1 and session 2 also.

// it saves memory even further

// second level caching is not available in Hibernate so we are going with 3rd party EH caching
// we will have a common cache for all session object

public class L2CacheExample {

	public static void main(String[] args) {
		SessionFactory sessionFactory = new Configuration().configure().addAnnotatedClass(Student.class).buildSessionFactory();
		Session session1=null;
		Session session2=null;
		
		try {
			session1 = sessionFactory.openSession();
			// Student student = session.get(Student.class, 1); // get data of ID=1 from student table
			session2 = sessionFactory.openSession(); // a L1 cache is there for this session object as well
			
			// Eager loading			
			Student student1 = session1.get(Student.class, 1);
			System.out.println(student1);
			
			Student student2 = session1.get(Student.class, 1);
			System.out.println(student2); // we are asking for the same query return record for id=1
			
			// second session
			
			Student student3 = session2.get(Student.class, 1);
			System.out.println(student3);
			
			Student student4 = session2.get(Student.class, 1);
			System.out.println(student4);
			
		}	
		
		catch(HibernateException e) {
			e.printStackTrace();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally 
		{
			session1.close();
			session2.close();
			sessionFactory.close();
		}

	}
}
