package com.dashboard.servicesImpl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.dashboard.controller.EmployeeController;
import com.dashboard.dao.entities.Employee;
import com.dashboard.dao.repositories.IEmployeeRepo;
import com.dashboard.services.IEmployeeService;

/**
 * @author Rahul This is implementation of services Employee Controller can make
 *         use of.
 *
 */
@Service
public class EmployeeServiceImpl implements IEmployeeService {
	private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeController.class);

	@Autowired
	IEmployeeRepo iEmployeeRepo;

	/**
	 * @param Employee Object
	 * @return True or false based on employee is added to DB.
	 */
	@Override
	public boolean addEmployee(Employee employee) {
		try {
			LOGGER.info("In ServiceImpl-->addEmployee(), calling DAL");
			Employee employeeObj = new Employee();
			employeeObj.setFirstName(employee.firstName);
			employeeObj.setLastName(employee.lastName);
			employeeObj.setEmail(employee.email);
			employeeObj.setContactNumber(employee.contactNumber);
			employeeObj.setDepartment(employee.department);
			return iEmployeeRepo.save(employeeObj);
		} catch (Exception ex) {
			LOGGER.error("In ServiceImpl-->addEmployee(), error occured while calling DAL. - {}", ex);
			return false;
		}
	}

	/**
	 * @return List of Employees
	 */
	@Override
	public List<Employee> getEmployeeList() {
		LOGGER.info("In ServiceImpl, calling getAll() of DAL");
		return iEmployeeRepo.getAll();
	}

	/**
	 * @return List of employees from Cache.
	 */
	@Cacheable("Employees")
	public List<Employee> addEmployee() {
		LOGGER.info("In ServiceImpl Cache, sending employee list");
		return iEmployeeRepo.getAll();
	}

}
