package com.learning.app;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.learning.model.Question;

public class RetrieveData {

	public static void main(String[] args) {

		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session1=null;
		
		/*
		 * one question: What's Hibernate?
		 * Multiple answers:
		 * Hibernate is an ORM framework
		   Hibernate is an implementation of JPA
		 */
		
		try {
			session1 = sessionFactory.openSession();
			// Student student = session.get(Student.class, 1); // get data of ID=1 from student table
								
			Question qa1 = session1.get(Question.class, 1); // get id 1 from Question class
			
			System.out.println("QA ID 1: "+qa1.getQuestion());
			qa1.getAnswers().forEach(n->System.out.println(n.getAnswer()));
			
		}
		catch (HibernateException e) 
		{
			e.printStackTrace();
		}
		
		catch (Exception e1) {
			e1.printStackTrace();
		}
		
		finally {
			
			session1.close();
			sessionFactory.close();
		}
	}

}
