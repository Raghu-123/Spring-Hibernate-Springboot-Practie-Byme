package com.raghu.springdemo.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.raghu.springdemo.entity.Customer;

@Repository
public class CustomerDaoImpl implements CustomerDao {

	//need to inject session factory
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<Customer> getCustomers() {
		
		//get the hibernate session
		Session session = sessionFactory.getCurrentSession();
		
		//create a query... sort by last name
		Query<Customer> theQuery = session.createQuery("from Customer order by lastName", Customer.class);
		
		//execute and get result list
		
		List<Customer> customerList = theQuery.getResultList();
		
		//return the results
		
		return customerList;
	}

	@Override
	public void saveCustomer(Customer theCustomer) {
		//get the current hibernate session
		Session session = sessionFactory.getCurrentSession();
		
		//save the customer object
		session.saveOrUpdate(theCustomer);
		
		
	}

	@Override
	public Customer getCustomer(int theId) {
		//get the hibernate session
		Session session = sessionFactory.getCurrentSession();
		
		//get the customer object
		
		Customer theCustomer = session.get(Customer.class, theId);
		
		
		//return the  requested customer object
		return theCustomer;
	}

	@Override
	public void deleteCustomer(int theId) {
		
		//get the hibernate session
		Session session = sessionFactory.getCurrentSession();
		
       /*//get the customer object
		
		Customer theCustomer = session.get(Customer.class, theId);
		
		//delete the customer from the database
		session.delete(theCustomer);
		*/
		Query theQuery = session.createQuery("delete from Customer where id=:customerId");
		theQuery.setParameter("customerId", theId);
		
		theQuery.executeUpdate();
		
	}

}
