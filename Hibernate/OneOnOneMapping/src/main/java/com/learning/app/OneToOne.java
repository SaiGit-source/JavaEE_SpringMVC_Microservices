package com.learning.app;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.learning.model.Answer;
import com.learning.model.Question;

// linking two tables in database is achieved with primary key and foreign key. linking two classes in Java is achieved using association.
// you dont have to worry about primary key foreign key, Hibernate will do everything in background

public class OneToOne {
	
	public static void main(String[] args) 
	{

	SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
	Session session1=null;
	Session session2=null;
	Transaction transaction = null;
	boolean create = false;
	
	try {
		session1 = sessionFactory.openSession();
		// Student student = session.get(Student.class, 1); // get data of ID=1 from student table
		session2 = sessionFactory.openSession(); // a L1 cache is there for this session object as well
		Question q1 = new Question();
		q1.setId(1);
		q1.setQuestion("What's Hibernate?");
		
		Answer answer1 = new Answer();
		answer1.setId(1);
		answer1.setAnswer("Hibernate is an ORM Framework");
		
		q1.setAnswer(answer1); // mapping question 1 to answer 1
		
		Question q2 = new Question();
		q2.setId(2);
		q2.setQuestion("What's JPA?");
		
		Answer answer2 = new Answer();
		answer2.setId(2);
		answer2.setAnswer("JPA is a specification used to persist data");
		
		q1.setAnswer(answer1); // mapping question 1 to answer 1
		q2.setAnswer(answer2);
		
		//Question qa1 = session1.get(Question.class, 1);
		//Question qa2 = session1.get(Question.class, 2);
		
		//System.out.println("QA ID 1: "+qa1);
		//System.out.println("QA ID 2: "+qa2);
		
		transaction = session1.beginTransaction();
		session1.persist(q1);
		session1.persist(q2);
		create=true;
	}
	catch (HibernateException e) 
	{
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

		session1.close();
		sessionFactory.close();
	}
	}
}
