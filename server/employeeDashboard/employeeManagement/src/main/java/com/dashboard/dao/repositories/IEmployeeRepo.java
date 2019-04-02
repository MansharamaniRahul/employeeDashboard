package com.dashboard.dao.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.dashboard.dao.entities.Employee;

//@Repository
//public interface IEmployeeRepo  extends MongoRepository<Employee, String> {
//	
//	boolean addEmployee(Employee employee);
//   
//}
@Repository
public interface IEmployeeRepo   {
	
	boolean save(Employee employee);
	
	List<Employee> getAll();
   
}