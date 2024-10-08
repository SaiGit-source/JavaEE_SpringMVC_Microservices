package com.learning.app;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.learning.model.Student;

public class DeleteClass {

	public static void main(String[] args) 
	{
		Configuration config = null;
		SessionFactory sessionFactory = null;
		Session session = null;
		Transaction transaction = null; // import from Hibernate only
		boolean deletedRec = false;
		
		config = new Configuration();
		config.configure();
		config.addAnnotatedClass(Student.class);
		sessionFactory = config.buildSessionFactory();
		
		try {
			session = sessionFactory.openSession();
			transaction=session.beginTransaction();
			Student st = new Student();
			/*
			st.setSid(4);
			st.setSname("Name4");
			st.setScity("Jacksonville");
			// session.delete(st); // deprecated
			session.persist(st);
			*/
			
			// remove() method instead of delete()
			st.setSid(2);
			st.setSname("Name1");
			st.setScity("Berlin");
			// session.delete(st); // deprecated
			
			session.remove(st);
			
			deletedRec = true;
		}
		catch(HibernateException e) {
			e.printStackTrace();
		}
 		catch(Exception e) {
 			e.printStackTrace();
 		}
		finally 
		{
			if (deletedRec==true) {
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
