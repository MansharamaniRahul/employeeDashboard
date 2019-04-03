package com.dashboard.dao.repositories;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.dashboard.dao.entities.Employee;

/**
 * @author Rahul
 * 
 *         Repository used to query DB.
 *
 */
@Repository
public interface IEmployeeRepo {

	boolean save(Employee employee);

	List<Employee> getAll();

}