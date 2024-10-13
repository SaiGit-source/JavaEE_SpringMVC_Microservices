package com.learning.app;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.learning.model.Student;

// In Lazy loading (getReference method), Hibernate is creating a Proxy object initially with only ID, based on the required data lets say name and city, it will retrieve data from database.
// the problem with Lazy loading is, it will throw an exception when ID/record is not found in the database

// In Eager loading (get method), Hibernate will go to the database and retrieve data and load into Student object, from which we can retrieve data

public class Lazy_EagerLoading {

	public static void main(String[] args) {
		SessionFactory sessionFactory = new Configuration().configure().addAnnotatedClass(Student.class).buildSessionFactory();
		Session session=null;
		
		try {
			session = sessionFactory.openSession();
			// Student student = session.get(Student.class, 1); // get data of ID=1 from student table
			
			// Lazy loading
			Student student = session.getReference(Student.class, 1); // load() method is deprecated. this is lazy loading two objects are created. twice this constructor runs -> Zero param Constructor for Hibernate
			// Student student = session.getReference(Student.class, 44); // lazy loading with no record in database throws an exception
			// System.out.println(student);
			// System.in.read(); // you need to hit enter to proceed
			
			// Eager loading			
			// Student student = session.get(Student.class, 1);
			// Student student = session.get(Student.class, 44); // it returns a 'null' object and so it goes into else block and no exception
			
			if (student != null) {
				System.out.println("ID: " + student.getSid() + ", Name: " + student.getSname() + ", City: " + student.getScity());
			}
			else {
				System.out.println("There is no record/data with given id");
			}
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
