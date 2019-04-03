package com.dashboard.services;

import java.util.List;

import com.dashboard.dao.entities.Employee;

/**
 * @author Rahul
 * 
 *         Interface to define all type of services Employee object can make use
 *         of.
 *
 */
public interface IEmployeeService {

	/**
	 * @param employee
	 * @return true, false based on employee added to DB.
	 */
	boolean addEmployee(Employee employee);

	/**
	 * @return List of Employees sorted by first name.
	 */
	List<Employee> getEmployeeList();
}
