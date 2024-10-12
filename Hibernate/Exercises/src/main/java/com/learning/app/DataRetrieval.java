package com.learning.app;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.learning.model.Student;
// this is only data retrieval or select operations so we dont need Transaction object
// two ways: get() and load() methods. this one will do the get() method

public class DataRetrieval {

	public static void main(String[] args) {
		SessionFactory sessionFactory = new Configuration().configure().addAnnotatedClass(Student.class).buildSessionFactory();
		Session session=null;
		
		try {
			session = sessionFactory.openSession();
			Student student = session.get(Student.class, 1); // get data of ID=1 from student table
			//System.out.println("ID: " + student.getSid() + ", Name: " + student.getSname() + ", City: " + student.getScity());
			System.out.println(student);
		}	
		
		catch(HibernateException e) {
			e.printStackTrace();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally 
		{
			session.close();
			sessionFactory.close();
		}

	}

}
