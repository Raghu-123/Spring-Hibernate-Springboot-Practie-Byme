package com.raghu.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.raghu.hibernate.demo.entity.Student;

public class PrimaryKeyDemo {

	public static void main(String[] args) {
		
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {
			System.out.println("Creating 3 new students....");
			Student student = new Student("Manyam","bhavani","manyambhavani01@gmail.com");
			Student student1 = new Student("Satyanarayana", "Uppalapati", "uppalapatisatyanaryan01@gmail.com");
			Student student2 = new Student("Ravana", "Uppalapati", "uppalapatiravana01@gmail.com");
			
			session.beginTransaction();
			System.out.println("saving the student details.....");
			session.save(student);
			session.save(student1);
			session.save(student2);
			System.out.println("Saved the student details successfully..");
			session.getTransaction().commit();
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		finally {
			factory.close();
		}
	}

}
