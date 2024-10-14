package com.learning.app;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.learning.model.Student;

/*
 * @Id
@GeneratedValue(strategy=GenerationType.IDENTITY) // to generate IDs automatically. specify .SEQUENCE for Oracle DB, .AUTO when DB vendor is unknown, .IDENTITY for MySQL
@SequenceGenerator(name="mySqequence", sequenceName="My_seq", initialValue=100,allocationSize=1); // our own sequence, allocationSize=1 increment by 1
 */
/*
 * Hibernate creates a table with auto_increment
   create table StudentTableAutoGenerate (
        SID integer not null auto_increment,
        SCITY varchar(255),
        SNAME varchar(255),
        primary key (SID)
    ) engine=InnoDB
 */

public class AutoGeneration {

	public static void main(String[] args) {
		SessionFactory sessionFactory = new Configuration().configure().addAnnotatedClass(Student.class).buildSessionFactory();
		Session session=null;
		Transaction transaction = null;
		boolean insert = false;
		
		try
		{
			session=sessionFactory.openSession();
			transaction=session.beginTransaction();
			Student student = new Student();
 			// student.setSid(3); we dont need this because Id will be automatically generated
 			student.setSname("StName2");
 			student.setScity("Charlotte");
			session.persist(student);
			insert=true;
		}
		catch (HibernateException e) {
			e.printStackTrace();
		}
		finally // this part is important only then it will perform insertion. commit()
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
