package com.raghu.springboot.cruddemo.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.raghu.springboot.cruddemo.entity.Employee;

@Repository
public class EmployeeDAOHIbernateImpl implements EmployeeDAO {

	//define field for entitymanager
	
	private EntityManager entityManager;
	
	//set up constructor injection
	@Autowired
	public EmployeeDAOHIbernateImpl(EntityManager theEntityManager) {
		entityManager = theEntityManager;
		
	}
	
	
	@Override
	@Transactional
	public List<Employee> findAll() {
		
		//get the current hibernate session
		
		Session currentSession = entityManager.unwrap(Session.class);
		
		//create a query
		
		Query query = currentSession.createQuery("from Employee", Employee.class);
		
		//execute query and get result list
		
		List<Employee> employees = query.getResultList();
		
		//return result list
		
		return employees;
	}


	@Override
	public Employee findById(int theId) {
		
		//get the current hibernate session
		
		Session currentSession = entityManager.unwrap(Session.class);
		
		//get the employee
		Employee theEmployee = currentSession.get(Employee.class, theId);
		
		//return the employee
		
		return theEmployee;
	}


	@Override
	public void save(Employee employee) {
		
		//get the current hibernate session
		
		Session currenSession = entityManager.unwrap(Session.class);
		
		//save employee
		currenSession.saveOrUpdate(employee);
		
		
	}


	@Override
	public void deleteById(int theId) {
		
		//get the current hibernate session
		Session currentSession = entityManager.unwrap(Session.class);
		
		
		//delete the object with primary key
		Query query = currentSession.createQuery("delete from Employee where id=:employeeId");
		
		query.setParameter("employeeId", theId);
		
		query.executeUpdate();
		
		
	}

}
