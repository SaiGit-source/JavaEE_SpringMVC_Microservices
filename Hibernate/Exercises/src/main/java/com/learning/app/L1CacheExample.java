package com.learning.app;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.learning.model.Student;

public class L1CacheExample {
	
	// L1Cache is a cache to store session objects. for each session, we will have a L1 cache. say within a session, we execute the same query it returns the object from the L1 cache so database hits are minimized. we dont want a database hit for a redundant query
	/*
	 * Hibernate: 
    select
        s1_0.SID,
        s1_0.SCITY,
        s1_0.SNAME 
    from
        StudentTable s1_0 
    where
        s1_0.SID=?
	Zero param Constructor for Hibernate
	Student [sid=1, sname=Name1, scity=Charlotte]
	Student [sid=1, sname=Name1, scity=Charlotte]
	 */
	// only one query is generated for session1 and session2 even though we have two get() method queries. because they are the same, the records are returned from session's L1 cache.
	// database hits are decreased and redundant queries dont go into database instead it returns the result from L1 cache

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
