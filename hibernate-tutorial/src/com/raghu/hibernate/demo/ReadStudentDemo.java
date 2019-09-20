package com.raghu.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.raghu.hibernate.demo.entity.Student;

public class ReadStudentDemo {

	public static void main(String[] args) {
		
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {
			
			Student student = new Student("Saradha","Uppalapati","saradhaupalapati1999@gmail.com");
			
			session.beginTransaction();
			
			session.save(student);
			
			session.getTransaction().commit();
			
			 session = factory.getCurrentSession();
			 
			 session.beginTransaction();
			 
			 Student gstudent = session.get(Student.class, student.getId());
			 
			 System.out.println("The student detais are:"+gstudent.toString());
			 
			 session.getTransaction().commit();
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		finally {
			factory.close();
		}
	}

}
