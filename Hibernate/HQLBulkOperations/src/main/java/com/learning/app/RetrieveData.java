package com.learning.app;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.learning.model.Student;

// Bulk data and complex data retrieval -> whenever we want to perform complex data retrieval say of specific columns not necessarily based on primary key or ID etc

public class RetrieveData {

	public static void main(String[] args) {
		SessionFactory sessionFactory = new Configuration().configure().addAnnotatedClass(Student.class).buildSessionFactory();
		Session session=null;
			
		try {
			session = sessionFactory.openSession();
			//SELECT * FROM STUDENTTABLE
			Query<Student> query = session.createQuery("FROM Student", Student.class);
			List<Student> listStudent = query.list(); // retrieved data JDBC will store in the form of resultSet
			// then we convert resultSet into list()
			listStudent.forEach(n->System.out.println(n));
			/*
			 * 	Student [sId=1, sName=Name1, sCity=Charlotte]
				Student [sId=3, sName=NameNew3, sCity=Portland]
				Student [sId=4, sName=Name4, sCity=Jacksonville]
			 */
			
			// bulk retrieval
			// directly we cannot perform this with Hibernate without HQL. we got to mention ID or so
			
			// retrieving data from a specific city
			// this is Full loading
			Query<Student> queryCity = session.createQuery("FROM Student WHERE sCity=:city", Student.class);
			queryCity.setParameter("city", "Jacksonville"); // :city is specifed here as Jacksonville
			List<Student> listStudentCity = queryCity.list(); // retrieved data based on city name
			listStudentCity.forEach(n->System.out.println(n));
			// Student [sId=4, sName=Name4, sCity=Jacksonville]
			// only Student from city Jacksonville is retrieved

			// retrieving data for specific columns
			// This is called as 'Partial loading' because only a few columns
			Query<String> queryColm = session.createQuery("SELECT sName FROM Student WHERE sCity=:city"); // we got to remove Student.class then change type to String from Student
			queryColm.setParameter("city", "Jacksonville"); // :city is specifed here as Jacksonville
			List<String> listStudentColm = queryColm.list(); // retrieved data based on city name
			listStudentColm.forEach(n->System.out.println(n));
			
			// it printed "Name4" only sName when sCity="Jacksonville"
			
			// resolve deprecated warning
			
			Query<String> queryName = session.createQuery("SELECT sName FROM Student WHERE sCity=:city", String.class); // we got to remove Student.class then change type to String from Student
			queryName.setParameter("city", "Jacksonville"); // :city is specifed here as Jacksonville
			List<String> listStudentName = queryName.list(); // retrieved data based on city name
			listStudentName.forEach(n->System.out.println(n));
			
			// records only from two cities, very specific and complex bulk operation so HQL
			Query<String> queryCities = session.createQuery("SELECT sName FROM Student WHERE sCity IN (:city1, :city2)", String.class); // we got to remove Student.class then change type to String from Student
			queryCities.setParameter("city1", "Jacksonville"); // :city is specifed here as Jacksonville
			queryCities.setParameter("city2", "Charlotte"); // two cities in the query
			List<String> listStudentCities = queryCities.list(); // retrieved data based on city name
			listStudentCities.forEach(n->System.out.println(n));
			
			/*
			 * 	Name1
				Name4
			 */
			
		}
		
		catch(HibernateException e) {
			e.printStackTrace();
		}
		catch(Exception e1) {
			e1.printStackTrace();
		}


	}

}
