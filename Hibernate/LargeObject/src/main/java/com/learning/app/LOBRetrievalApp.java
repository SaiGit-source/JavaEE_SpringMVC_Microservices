package com.learning.app;

import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.learning.model.StudentInfo;

public class LOBRetrievalApp {

	public static void main(String[] args) {
		
		SessionFactory sessionFactory = new Configuration().configure().addAnnotatedClass(StudentInfo.class).buildSessionFactory();
		Session session=null;
		FileOutputStream fos=null;
		FileWriter writer=null;
				
		try {
			session = sessionFactory.openSession();
			StudentInfo studentInfo = session.get(StudentInfo.class, 1);
			fos = new FileOutputStream("Java_retrieved.svg");
			writer = new FileWriter("Clob_retrieved.txt");
			fos.write(studentInfo.getImage());		
			char retrieve[] = studentInfo.getTextFile();
			writer.write(studentInfo.getTextFile());
			
		}
		catch (HibernateException e) 
		{
			e.printStackTrace();
		}
		
		catch (Exception e1) {
			e1.printStackTrace();
		}
		
		finally {
			
			try {
				writer.close();
				fos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			session.close();
			sessionFactory.close();
		}
	

	}

}
