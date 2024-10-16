package com.learning.app;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.learning.model.Courses;
import com.learning.model.Students;

public class ManyToManyExample {

	public static void main(String[] args) {
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session=null;
	
		Transaction transaction = null;
		boolean create = false;
		
		session = sessionFactory.openSession();
		
		Courses c1 = new Courses();
		c1.setId(1);
		c1.setCourseName("Java");
		c1.setCoursePrice(2000);
		
		Courses c2 = new Courses();
		c2.setId(2);
		c2.setCourseName("SpringBoot");
		c2.setCoursePrice(1000);
		
		Courses c3 = new Courses();
		c3.setId(3);
		c3.setCourseName("Hibernate");
		c3.setCoursePrice(500);		
		
		Set<Courses> set1 = new HashSet<>();
		set1.add(c1);
		set1.add(c2);
		set1.add(c3);
		
		// one student might have taken 3 courses, one might have taken 2 courses to differentiate we do this
		Set<Courses> set2 = new HashSet<>();
		set2.add(c1);
		set2.add(c2);

		Students s1 = new Students();
		s1.setId(1);
		s1.setCourses(set1);
		s1.setCity("Charlotte");
		
		// this student has taken only 2 courses
		Students s2 = new Students();
		s2.setId(2);
		s2.setCourses(set2);
		s2.setCity("Indianapolis");
		
		Students s3 = new Students();
		s3.setId(3);
		s3.setCourses(set1);
		s3.setCity("Portland");
		
		
		try {
			transaction = session.beginTransaction();
			// because of cascade, if i save question, answers automatically should be saved
			session.persist(s1);
			session.persist(s2);
			session.persist(s3);
			create=true;

		}
		catch(HibernateException e) {
			e.printStackTrace();
		}
		catch (Exception e1) {
			e1.printStackTrace();
		}
		finally {
			
			if (create==true) {
				transaction.commit();
			}
			else {
				transaction.rollback();
			}

			session.close();
			sessionFactory.close();
		}

	}

}
