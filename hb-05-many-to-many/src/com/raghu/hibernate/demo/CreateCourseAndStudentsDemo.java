package com.raghu.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.raghu.hibernate.demo.entity.Course;
import com.raghu.hibernate.demo.entity.Instructor;
import com.raghu.hibernate.demo.entity.InstructorDetail;
import com.raghu.hibernate.demo.entity.Review;
import com.raghu.hibernate.demo.entity.Student;

public class CreateCourseAndStudentsDemo {

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
			
			//create a course
			Course tempCourse = new Course("Spring - Learn Spring Framework");
			
			
			//save the course
			System.out.println("\n Saving the course!");
			session.save(tempCourse);
			System.out.println("\n Saved the Course: "+tempCourse);
			
			//create the course
			
			Student tempStudent1 =new Student("Janaki", "Uppalapati","janakiuppalapati1997@gmail.com");
			Student tempStudent2 =new Student("Sarada", "Uppalapati","saradauppalapati1997@gmail.com");
			
			//add the student to the course
			tempCourse.addStudent(tempStudent1);
			tempCourse.addStudent(tempStudent2);
			
			
			//save the students
			System.out.println("\n Saving the Students...");
			session.save(tempStudent1);
			session.save(tempStudent2);
			System.out.println("\n Saved the Students : "+tempCourse.getStudents());
			
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
