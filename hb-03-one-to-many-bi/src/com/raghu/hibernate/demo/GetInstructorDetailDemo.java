package com.raghu.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.raghu.hibernate.demo.entity.Instructor;
import com.raghu.hibernate.demo.entity.InstructorDetail;

public class GetInstructorDetailDemo {

	public static void main(String[] args) {
		
		//create sessionfactory
		
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
				                 .addAnnotatedClass(Instructor.class)
				                 .addAnnotatedClass(InstructorDetail.class)
				                 .buildSessionFactory();
		//create session
		Session session = factory.getCurrentSession();
		
		try {
			
			//start a transaction
			session.beginTransaction();
			
			//get the instructor detail object
			
			int theId =2;
			InstructorDetail tepmInstructorDetail = session.get(InstructorDetail.class, theId);
			
			if (tepmInstructorDetail != null) {
				
			
			//print the instructor detail
			System.out.println("TempInstructorDetails: "+tepmInstructorDetail);
			
			//print associated instructor 
			
			System.out.println("The Associated Instructor: "+tepmInstructorDetail.getInstructor());
			}
			//commit the transaction
			
			session.getTransaction().commit();
			
			System.out.println("Done!");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		finally{
			session.close();
			factory.close();
		}

	}

}
