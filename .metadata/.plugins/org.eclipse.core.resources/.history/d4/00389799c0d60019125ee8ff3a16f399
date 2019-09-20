package com.raghu.springboot.cruddemo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.raghu.springboot.cruddemo.dao.EmployeeRepository;
import com.raghu.springboot.cruddemo.entity.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	private EmployeeRepository employeeRepository;
	
	 public EmployeeServiceImpl(EmployeeRepository theEmployeeRepository) {
		 employeeRepository = theEmployeeRepository;
	}

	@Override
	public List<Employee> findAll() {
		
		return employeeRepository.findAll();
	}

	@Override
	public Employee findById(int theId) {
		
		Optional<Employee> result = employeeRepository.findById(theId);
		
		Employee theEmployee = null;
		if (result.isPresent()) {
			theEmployee = result.get();
			
		}
		
		else {
			throw new RuntimeException("Did Not Find Employee Id -"+theId);
		}
		return theEmployee;
	}

	@Override
	public void save(Employee employee) {
		
		employeeRepository.save(employee);

	}

	@Override
	public void deleteById(int theId) {
		employeeRepository.deleteById(theId);

	}

}
