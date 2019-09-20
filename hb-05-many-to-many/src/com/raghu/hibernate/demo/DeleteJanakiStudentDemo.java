package com.raghu.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.raghu.hibernate.demo.entity.Course;
import com.raghu.hibernate.demo.entity.Instructor;
import com.raghu.hibernate.demo.entity.InstructorDetail;
import com.raghu.hibernate.demo.entity.Review;
import com.raghu.hibernate.demo.entity.Student;

public class DeleteJanakiStudentDemo {

	public static void main(String[] args) {
		
		//create sessionfactory
		
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
				                 .addAnnotatedClass(Instructor.class)
				                 .addAnnotatedClass(InstructorDetail.class)
				                 .addAnnotatedClass(Course.class)
				                 .addAnnotatedClass(Review.class)
				                 .addAnnotatedClass(Student.class)
				                 .buildSessionFactory();
		//create session
		Session session = factory.getCurrentSession();
		
		try {
		
			
			
			//start a transaction
			session.beginTransaction();
			
			int theId = 1;
			
			//get the student from the database
			
			Student tempStudent = session.get(Student.class, theId);
			
			System.out.println("\n Loaded Student :"+tempStudent);
			System.out.println("\n Courses of Student :"+tempStudent.getCourses());
			
			//delete the student
			System.out.println("\n Deleting the Student..");
			session.delete(tempStudent);
			System.out.println("\n Student is deleted");
			//commit the transaction
			
			session.getTransaction().commit();
			
			System.out.println("Done!");
		} catch (Exception e) {
			
		}
		
		finally{
			//add clean up code
			session.close();
			
			factory.close();
		}

	}

}
