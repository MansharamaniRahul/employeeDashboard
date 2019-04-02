package com.dashboard.services;

import java.util.List;

import com.dashboard.dao.entities.Employee;

public interface IEmployeeService {

	boolean addEmployee(Employee employee);
	List<Employee> getEmployeeList();
}
