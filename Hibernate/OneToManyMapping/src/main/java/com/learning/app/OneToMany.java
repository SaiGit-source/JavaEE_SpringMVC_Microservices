package com.learning.app;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.learning.model.Answers;
import com.learning.model.Question;

public class OneToMany {

	public static void main(String[] args) {
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session1=null;
	
		Transaction transaction = null;
		boolean create = false;
		
		try {
			session1 = sessionFactory.openSession();
			// Student student = session.get(Student.class, 1); // get data of ID=1 from student table

			Question q1 = new Question();
			q1.setId(1);
			q1.setQuestion("What's Hibernate?");
			
			Answers a1 = new Answers();
			a1.setId(1);
			a1.setAnswer("Hibernate is an ORM framework");
			a1.setQuestion(q1);
			
			Answers a2 = new Answers();
			a2.setId(2);
			a2.setAnswer("Hibernate is an implementation of JPA");
			a2.setQuestion(q1);
			
			List<Answers> answers = new ArrayList<Answers>();
			answers.add(a1);
			answers.add(a2);
			
			q1.setAnswers(answers); 
			
			transaction = session1.beginTransaction();
			// because of cascade, if i save question, answers automatically should be saved
			session1.persist(q1);
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

