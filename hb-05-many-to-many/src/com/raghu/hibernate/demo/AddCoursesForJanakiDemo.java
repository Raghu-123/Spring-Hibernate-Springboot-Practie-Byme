package com.raghu.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.raghu.hibernate.demo.entity.Course;
import com.raghu.hibernate.demo.entity.Instructor;
import com.raghu.hibernate.demo.entity.InstructorDetail;
import com.raghu.hibernate.demo.entity.Review;
import com.raghu.hibernate.demo.entity.Student;

public class AddCoursesForJanakiDemo {

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
			//create the objects

			//associate the objects
			
			
			//start a transaction
			session.beginTransaction();
			
			int theId = 1;
			
			//get the student from the database
			
			Student tempStudent = session.get(Student.class, theId);
			
			System.out.println("\n Loaded Student :"+tempStudent);
			System.out.println("\n Courses of Student :"+tempStudent.getCourses());
			
			//create more courses
			Course tempCourse = new Course("Angular 7 - The Best FrontEnd Development FrameWork ");
			Course tempCourse1 = new Course("Atari 2600 - Game Development");
			
			//add student to the courses
			tempCourse.addStudent(tempStudent);
			tempCourse1.addStudent(tempStudent);
			
			
			//save the course
			System.out.println("\n Saving the courses!");
			session.save(tempCourse);
			session.save(tempCourse1);
			System.out.println("\n Saved the Course: "+tempCourse);
			
			
			
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
