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
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

/**
 * @author Rahul
 * 
 *         The Controller class is used to handle request for actions related to
 *         Employee Object. All CRUD operation over employee object will be
 *         handled by this class.
 *
 */
@CrossOrigin
@RestController
public class EmployeeController {

	private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeController.class);

	@Autowired
	IEmployeeService employeeServiceImpl;

	/**
	 * @param employeeObj
	 * @return true if employee added else false
	 */
	@RequestMapping(value = "/addEmployee", method = RequestMethod.POST)
	@ResponseBody
	public boolean addEmployee(@RequestBody Employee employeeObj) {
		try {
			LOGGER.info("Req to add Employee to db received. Obj is - {}", employeeObj);
			return employeeServiceImpl.addEmployee(employeeObj);
		} catch (Exception ex) {
			LOGGER.error("Error occured while wsaving Employee to DB.");
			return false;
		}
	}

	/**
	 * @return List of Employees
	 */

	@RequestMapping(value = "/getEmployeeList", method = RequestMethod.GET)
	@ResponseBody
	public List<Employee> getEmployeeList() {
		try {
			LOGGER.info("Req received to get list of Employees");
			return employeeServiceImpl.getEmployeeList();
		} catch (Exception ex) {
			LOGGER.error("Error Occured while fetching Employee List");
			return null;
		}
	}
}
