package com.dashboard.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.dashboard.dao.entities.Employee;
import com.dashboard.services.IEmployeeService;


@CrossOrigin
@RestController
public class EmployeeController {
	
	@Autowired
	IEmployeeService employeeServiceImpl;
	
	
	
	@RequestMapping(value="/addEmployee", method=RequestMethod.POST)
	@ResponseBody
    public boolean addEmployee(@RequestBody Employee employeeObj) {
		try {
        return employeeServiceImpl.addEmployee(employeeObj);
		}
		catch(Exception ex){
			System.out.println(ex);
			return false;
		}
    }
	
	@RequestMapping(value="/getEmployeeList", method=RequestMethod.GET)
	@ResponseBody
    public List<Employee> getEmployeeList() {
		try {
        return employeeServiceImpl.getEmployeeList();
		}
		catch(Exception ex){
			System.out.println(ex);
			return null;
		}
    }
}
