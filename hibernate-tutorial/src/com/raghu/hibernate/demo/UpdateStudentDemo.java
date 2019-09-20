package com.raghu.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.raghu.hibernate.demo.entity.Student;

public class UpdateStudentDemo {

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
			 
			 //Student gstudent = session.get(Student.class, studentID);
			 
			 //delete the student
			// System.out.println("\n Deleting the Student with ID: "+studentID);
			 //session.delete(gstudent);
			 
			 //System.out.println("The student detais are:"+gstudent.toString());
			 
			 //delete student with id=2
			 System.out.println("Deleting the Studentwith id =2 ");
			 session.createQuery("delete from Student where id=2").executeUpdate();
			 
			 session.getTransaction().commit();
			 
		} catch (Exception e) {
			// TODO: handle exception
		}
		finally {
			factory.close();
		}
	}

}
