package com.raghu.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.raghu.hibernate.demo.entity.Instructor;
import com.raghu.hibernate.demo.entity.InstructorDetail;

public class CreateDemo {

	public static void main(String[] args) {
		
		//create sessionfactory
		
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
				                 .addAnnotatedClass(Instructor.class)
				                 .addAnnotatedClass(InstructorDetail.class)
				                 .buildSessionFactory();
		//create session
		Session session = factory.getCurrentSession();
		
		try {
			//create the objects
//			Instructor tempInstructor = new Instructor("Raghu", "Manyam", "manyamraghu1994@gmail.com");
//			
//			InstructorDetail tempInstructorDetail = new InstructorDetail("http://luv2code.com//youtube","luv 2 code!!"); 
//			
            Instructor tempInstructor = new Instructor("Janaki", "Uppalapati", "uppalapatijankai1997@gmail.com");
			
			InstructorDetail tempInstructorDetail = new InstructorDetail("http://luv2cook.com//youtube","luv 2 cook!!"); 
			
			//associate the objects
			
			tempInstructor.setInstructorDetail(tempInstructorDetail);
			
			//start a transaction
			session.beginTransaction();
			
			//save the instructor
			//
			//Note: this will also save the detials object
			//because of the CASCADE.ALL
			//
			System.out.println("Saving Instructor:"+tempInstructor);
			session.save(tempInstructor);
			
			//commit the transaction
			
			session.getTransaction().commit();
			
			System.out.println("Done!");
		} catch (Exception e) {
			
		}
		
		finally{
			factory.close();
		}

	}

}
