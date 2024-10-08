package com.learning.app;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.learning.model.Student;

public class UpdateClass {

	public static void main(String[] args) 
	{
		Configuration config = null;
		SessionFactory sessionFactory = null;
		Session session = null;
		Transaction transaction = null; // import from Hibernate only
		boolean updatedRec = false;
		
		config = new Configuration();
		config.configure();
		config.addAnnotatedClass(Student.class);
		sessionFactory = config.buildSessionFactory();
		// sessionFactory = new Configuration().configure().addAnnotatedClass(Student.class).buildSessionFactory(); // this also works, more efficient way of writing the code
 		
 		
		try {
 			session = sessionFactory.openSession();
 			transaction=session.beginTransaction();
 			Student st = new Student();
 			/* works for update only
 			st.setSid(2);
 			st.setSname("Name1");
 			st.setScity("Berlin");	
 			*/
 			// this id is not there already in the database so we use saveOrUpdate()
 			st.setSid(3);
 			st.setSname("NameNew3");
 			st.setScity("Portland");
 			
 			//session.update(st);// deprecated from Hibernate 6
 			//session.saveOrUpdate(st); // it will go for update() first otherwise will insert new record
 			session.merge(st); // for update operation
 			updatedRec = true;
 		}
 		catch(HibernateException e) {
 			e.printStackTrace();
 		}
 		catch(Exception e) {
 			e.printStackTrace();
 		}
		finally 
		{
			if (updatedRec==true) {
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
