package com.dashboard.dao.repositoriesImpl;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

import com.dashboard.dao.entities.Employee;
import com.dashboard.dao.repositories.IEmployeeRepo;

@Repository
public  class IEmployeeRepoImpl implements IEmployeeRepo{
	
	@Autowired
	private MongoTemplate mongoTemplate;

	@Override
	public boolean save(Employee employee) {
		boolean saved = true;
		try{
			mongoTemplate.save(employee, "Employee");
		}catch(Exception ex) {
			saved = false;
		}
		return saved;
	}

	@Override
	public List<Employee> getAll() {
		try{
		return	mongoTemplate.findAll(Employee.class );
		}catch(Exception ex) {
			
		}
		return null;
	}
	
	

	}
