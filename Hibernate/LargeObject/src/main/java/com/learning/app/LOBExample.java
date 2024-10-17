package com.learning.app;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.learning.model.StudentInfo;

public class LOBExample {

	public static void main(String[] args) {
		
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session=null;
	
		Transaction transaction = null;
		boolean create = false;
		
		// FileReader class to get txt file from local into application
		// For binary data in the form of bytes, FileInputStream
		// IO package
		
		FileInputStream fis = null; // do it here so we can close in the finally block
		byte image[] = null;
		FileReader reader = null; // now it is accessible in the finally block and we can close it there
		char[] textFile = null;
		
		session = sessionFactory.openSession();
		
		
		// FileReader class to get txt file from local into application
		// For binary data in the form of bytes, FileInputStream
		// IO package
		
		try {
			// this is for BLOB
			fis = new FileInputStream("C:\\Dummy\\java-1.svg");
			// if you create fis here, then the access is limited to only this block and we cannot close in the finally block
			image=new byte[fis.available()]; // bytes of this image fis.available(). available() is like size(), entire image i can fit in here
			fis.read(image); // entire in binary format or bytes we are reading into image byte array
			
			// this is for CLOB or text object
			
			File file = new File("C:\\Dummy\\clob.txt");
			reader = new FileReader(file); // needed to get file into Java application
			textFile=new char[(int)file.length()];
			reader.read(textFile);
			
			
		} catch (FileNotFoundException e) {

			e.printStackTrace();
		}
		
		catch (Exception e1) {
			e1.printStackTrace();
		}
		
		StudentInfo st = new StudentInfo();
		
		st.setsName("Name1LOB");
		st.setsCity("Chicago");
		st.setImage(image);
		st.setTextFile(textFile);
		
		try {
			transaction = session.beginTransaction();
			// because of cascade, if i save question, answers automatically should be saved
			session.persist(st); // i am saving this entire object, rest of the part Hibernate will take care
			create=true;

		}
		catch(HibernateException e) {
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
			
			try {
				fis.close();
				reader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}

			session.close();
			sessionFactory.close();
		}

	}

}
