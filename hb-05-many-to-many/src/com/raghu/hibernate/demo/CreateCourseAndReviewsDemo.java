package com.raghu.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.raghu.hibernate.demo.entity.Course;
import com.raghu.hibernate.demo.entity.Instructor;
import com.raghu.hibernate.demo.entity.InstructorDetail;
import com.raghu.hibernate.demo.entity.Review;

public class CreateCourseAndReviewsDemo {

	public static void main(String[] args) {
		
		//create sessionfactory
		
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
				                 .addAnnotatedClass(Instructor.class)
				                 .addAnnotatedClass(InstructorDetail.class)
				                 .addAnnotatedClass(Course.class)
				                 .addAnnotatedClass(Review.class)
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
			
			
			//add some reviews
			
			tempCourse.addReview(new Review("Great course .. loved it"));
			tempCourse.addReview(new Review("Cool course, good job well done!"));
			tempCourse.addReview(new Review("What a dumb course.."));
			
			//save the course ... and leverage the cascade all :-
			System.out.println("Saving the course..");
			System.out.println(tempCourse);
			System.out.println("Reviews for the course: "+tempCourse.getReviews());
			session.save(tempCourse);
			
			
			
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
