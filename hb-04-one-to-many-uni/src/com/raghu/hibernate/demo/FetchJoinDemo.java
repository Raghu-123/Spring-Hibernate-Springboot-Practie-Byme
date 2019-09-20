package com.raghu.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.raghu.hibernate.demo.entity.Course;
import com.raghu.hibernate.demo.entity.Instructor;
import com.raghu.hibernate.demo.entity.InstructorDetail;

public class FetchJoinDemo {

	public static void main(String[] args) {
		
		//create sessionfactory
		
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
				                 .addAnnotatedClass(Instructor.class)
				                 .addAnnotatedClass(InstructorDetail.class)
				                 .addAnnotatedClass(Course.class)
				                 .buildSessionFactory();
		//create session
		Session session = factory.getCurrentSession();
		
		try {
			//create the objects

			//associate the objects
			
			System.out.println("Transaction is begining!!");
			//start a transaction
			session.beginTransaction();
			
			System.out.println("Transaction has been started!!");
			
			//Option 2: Hibernate query with HQL
			
			//get the instructor from the db
			int theId = 1;
			
			Query<Instructor> query = session.createQuery("select i from Instructor i "
					                                    + "JOIN FETCH i.courses "
					                                    + " where i.id=:theInstructorId ",Instructor.class);
			
			System.out.println("Query has been inserted!!");
			
			//set the query param
			query.setParameter("theInstructorId", theId);
			
			//execute the query and get the instructor
			
			Instructor tempInstructor =  query.getSingleResult();
			
			System.out.println("Raghu : Instructor: "+tempInstructor);
			
			//get the course for the instructor
			
			System.out.println("Raghu : Courses: "+tempInstructor.getCourses());
			
			//commit the transaction
			
			session.getTransaction().commit();
			
			//close the session
			session.close();
			
			System.out.println("\n Raghu : Session is now closed!!\n");
			//get the coureses after closing the session
			
			System.out.println("Raghu : Courses: "+tempInstructor.getCourses());
			
			
			System.out.println("Raghu : Done!");
		} catch (Exception e) {
			
		}
		
		finally{
			//add clean up code
			session.close();
			
			factory.close();
		}

	}

}
