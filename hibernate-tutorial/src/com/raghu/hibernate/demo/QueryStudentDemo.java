package com.raghu.hibernate.demo;

import java.util.List;
import java.util.function.Consumer;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.raghu.hibernate.demo.entity.Student;

public class QueryStudentDemo {
	
	public static void main(String[] args) {
	//create session factory
	SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
			                 .addAnnotatedClass(Student.class)
			                 .buildSessionFactory();
	
	//create session
    Session session = factory.getCurrentSession();
    
    try {
		//start session
		session.beginTransaction();
		
		List<Student> theStudent = session.createQuery("from Student").getResultList();
		
			/*
			 * Consumer<Student> consumer = System.out::print; theStudent.forEach(consumer);
			 */	
		displayStudents(theStudent);
		//query for the last name ="uppalapati"
		theStudent=session.createQuery("from Student s where s.lastName='bhavani'").getResultList();
		System.out.println("Students who have lastName bhavani:");
		displayStudents(theStudent);
		
		
		//query the students:lastName:bhavni or firstName: Manyam
		
		theStudent = session.createQuery("from Student s where s.lastName='bhavani' OR "
				     + " s.firstName='Manyam'").getResultList();
		
		System.out.println("\n Student who is having LastName:bhavani OR FirstName :Manyam");
		displayStudents(theStudent);
		
		
		//query student where email like '%@gmail.com'
		
		theStudent = session.createQuery("from Student s where"
				+ " s.email LIKE '%@gmail.com'").getResultList();
		System.out.println("\n Student who is having email LIKE '%@gmail.com'");
		displayStudents(theStudent);
		
		//commit transaction
		session.getTransaction().commit();
		
	} finally {
		// TODO: handle finally clause
		factory.close();
	}
    
    
}

	private static void displayStudents(List<Student> theStudent) {
		for (Student student : theStudent) {
			
			System.out.println("The student details:"+student.toString());
			
		}
	}
}
