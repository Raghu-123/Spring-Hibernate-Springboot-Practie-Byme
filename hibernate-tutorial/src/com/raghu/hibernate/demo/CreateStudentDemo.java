package com.raghu.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.raghu.hibernate.demo.entity.Student;

public class CreateStudentDemo {

	public static void main(String[] args) {
		//create session factory
		SessionFactory factory = new Configuration()
				                .configure("hibernate.cfg.xml")
				                .addAnnotatedClass(Student.class)
				                .buildSessionFactory();
		
		//create a session
		Session session = factory.getCurrentSession();
		
		try {
			//use the session object to save Java object
			
			//create a student object
			Student student = new Student("Uppalapati","Janaki","uppalapatijanaki1994@gmail.com");
			
			//start a transaction
			session.beginTransaction();
			
			//save the student object
			System.out.println("saving the student details.....");
			session.save(student);
			System.out.println("Saved the student details successfully..");
			
			//commit the transaction
			session.getTransaction().commit();
			
			System.out.println("Done!");
		} catch (Exception e) {
			// TODO: handle exception
		}
		finally {
			factory.close();
		}
		 
	}

}
