package com.learning.app;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.learning.model.NewStudent;

// non-select operation update, insert or delete with HQL

public class DeleteData {

	public static void main(String[] args) {
		SessionFactory sessionFactory = new Configuration().configure().addAnnotatedClass(NewStudent.class).buildSessionFactory();
		Session session=null;
	
		Transaction transaction = null;
		boolean delete = false;
		int count = 0;
		
		session = sessionFactory.openSession();
		
		try {
			transaction = session.beginTransaction();
			// because of cascade, if i save question, answers automatically should be saved
			/*
			 * count=session.createQuery("UPDATE NewStudent SET sCity=:city")
			 * .setParameter("city", "Akron").executeUpdate(); // rename city in all rows to
			 * Akron
			 */
			// that one is deprecated
			
			count=session.createMutationQuery("DELETE NewStudent WHERE sId=:id")
			.setParameter("id", 4).executeUpdate();
			
			delete = true;
		}
		
		catch(HibernateException e) {
			e.printStackTrace();
		}
		
		catch (Exception e1) {
			e1.printStackTrace();
		}
		
		finally {
			
			if (delete==true) {
				transaction.commit();
				System.out.println("Num of rows affected: "+count);
				// Num of rows affected: 1
			}
			
			else {
				transaction.rollback();
			}

			session.close();
			sessionFactory.close();
		}

	}

}
