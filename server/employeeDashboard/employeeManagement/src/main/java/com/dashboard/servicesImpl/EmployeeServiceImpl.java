package com.dashboard.servicesImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.dashboard.dao.entities.Employee;
import com.dashboard.dao.repositories.IEmployeeRepo;
import com.dashboard.services.IEmployeeService;

@Service
public class EmployeeServiceImpl implements IEmployeeService {

	
	@Autowired
	IEmployeeRepo iEmployeeRepo;
	
	
	@Override
	public boolean addEmployee(Employee employee) {
		try {		
		Employee employeeObj = new Employee();
		employeeObj.setFirstName(employee.firstName);
		employeeObj.setLastName(employee.lastName);
		employeeObj.setEmail(employee.email);
		employeeObj.setContactNumber(employee.contactNumber);
		employeeObj.setDepartment(employee.department);
		return iEmployeeRepo.save(employeeObj);
		}
		catch(Exception ex) {
			return false;
		}
		}


	@Override
	public List<Employee> getEmployeeList() {
		return iEmployeeRepo.getAll();	
	}
	
	@Cacheable("addEmployee")
	public boolean addEmployee() {
		return false;
	}

}
