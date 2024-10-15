package com.learning.app;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.learning.model.Answer;
import com.learning.model.Question;

// important set cfg file to update not create

public class OneToOne_getMethod {
	public static void main(String[] args) 
	{

	SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
	Session session1=null;
	
	try {
		session1 = sessionFactory.openSession();
		// Student student = session.get(Student.class, 1); // get data of ID=1 from student table
		
		/*
		 * QA ID 1: Question [id=1, question=What's Hibernate?, answer=Answer [id=1, answer=Hibernate is an ORM Framework]]
QA ID 2: Question [id=2, question=What's JPA?, answer=Answer [id=2, answer=JPA is a specification used to persist data]]
		 */
		
		Question qa1 = session1.get(Question.class, 1);
		Question qa2 = session1.get(Question.class, 2);
		
		System.out.println("QA ID 1: "+qa1);
		System.out.println("QA ID 2: "+qa2);
		
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
