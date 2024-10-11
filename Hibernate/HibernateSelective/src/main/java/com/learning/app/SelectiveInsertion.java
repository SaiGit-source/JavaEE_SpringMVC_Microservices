package com.learning.app;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.learning.model.Employee1;

// lets say i want to create a new table with selective columns like name, age, but no city
// we use @Transient annotation

public class SelectiveInsertion {

	public static void main(String[] args) {
		SessionFactory sessionFactory = new Configuration().configure().addAnnotatedClass(Employee1.class).buildSessionFactory();
		Session session=null;
		Transaction transaction = null;
		boolean insert = false;
		
		try
		{
			session=sessionFactory.openSession();
			transaction=session.beginTransaction();
			Employee1 e = new Employee1();
			e.seteAge(1);
			e.seteId(1);
			e.seteName("Selective");
			e.seteCity("Tampa"); // say i dont want this field part of my table so use @Transient
			session.persist(e);
			insert=true;
		}
		catch (HibernateException e) {
			e.printStackTrace();
		}
		finally
		{
			if(insert==true) {
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
