package com.learning.app;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.learning.model.Student;

public class FirstApplication {

	public static void main(String[] args) {
		// Step 1: create configuration object
		Configuration config = new Configuration();
		
		// Step 2: configure hibernate.cfg.xml file to Configuration object
		config.configure(); // if you dont change the default filename: hibernate.cfg.xml then it fine
		// config.configure("hib.config.xml"); // if a different filename is specified
		
		// Step 3: Create SessionFactory object
		SessionFactory sessionFactory=config.buildSessionFactory();
		
		// Step 4: Get session object from Session Factory
		Session session = sessionFactory.openSession();
		
		// to insert data, we need a Transaction object - non-select operation
		// Step 5: Begin Transaction within Session
		Transaction transaction = session.beginTransaction();
		
		Student student = new Student();
		student.setSid(1);
		student.setSname("Name1");
		student.setScity("Charlotte");
		
		// Step 6: Perform operation
		session.save(student); // save entire object
		
		// Step 7: Perform Transaction operations
		transaction.commit();
		
		// Step 8: Close the session / resources
		session.close();
		
	}

}
