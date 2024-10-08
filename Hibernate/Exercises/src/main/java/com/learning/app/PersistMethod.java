package com.learning.app;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.learning.model.Student;

// only inserting record into an existing table so in config file we keep only
// <property name="hibernate.hbm2ddl.auto">update</property>

public class PersistMethod {

	public static void main(String[] args) 
	{
		Configuration config = null;
		SessionFactory sessionFactory = null;
		Session session = null;
		Transaction transaction = null; // import from Hibernate only
		boolean insertOpn=false;
		
		config = new Configuration();
		config.configure();
		sessionFactory = config.buildSessionFactory(); // all objects required for Hibernate will be there in the Session Factory
		session=sessionFactory.openSession(); // get one session object
		Student student = new Student();
		student.setSid(2);
		student.setSname("Name2");
		student.setScity("Portland");
		
		// for insertion operation we need Transaction
		
		try
		{
			transaction = session.beginTransaction();
			session.persist(student); // new method in Hibernate new versions
			insertOpn = true;
		}
		catch(HibernateException e)
		{
			e.printStackTrace();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
		
			if(insertOpn==true) 
				{
					transaction.commit();
				} 
			else 
				{
					transaction.rollback();
				}
			
		}
	
	}

}
