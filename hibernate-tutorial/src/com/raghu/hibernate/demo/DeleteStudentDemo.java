package com.raghu.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.raghu.hibernate.demo.entity.Student;

public class DeleteStudentDemo {

	public static void main(String[] args) {
		
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {
		
		int studentID=1;	
			//find out the student id:primarykey
		System.out.println("Student id is :"+studentID);
			 
			 session.beginTransaction();
			 
			 //retrive the student based on the id : primarykey
			 System.out.println("\n Getting the student with ID :"+studentID);
			 
			 Student gstudent = session.get(Student.class, studentID);
			 
			 gstudent.setLastName("Raghu");
			 
			 System.out.println("The student detais are:"+gstudent.toString());
			 
			 session.getTransaction().commit();
			 
			 //new code
			 
			 session = factory.getCurrentSession();
			 session.beginTransaction();
			 
			 
			 
			 //update email for all students
			 System.out.println("\n updating all the Emailid's \n");
			 session.createQuery("update Student set email='manyamraghu1994@gmail.com'")
			 .executeUpdate();
			 
			 session.getTransaction().commit();
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		finally {
			factory.close();
		}
	}

}
