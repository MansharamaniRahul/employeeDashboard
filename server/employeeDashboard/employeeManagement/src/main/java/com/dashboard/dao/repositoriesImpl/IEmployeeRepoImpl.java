package com.dashboard.dao.repositoriesImpl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import com.dashboard.dao.entities.Employee;
import com.dashboard.dao.repositories.IEmployeeRepo;

/**
 * @author Rahul
 * 
 *         This is DAL, that interacts with DB to perform respective operations.
 *
 */
@Repository
public class IEmployeeRepoImpl implements IEmployeeRepo {

	private static final Logger LOGGER = LoggerFactory.getLogger(IEmployeeRepoImpl.class);
	
	@Autowired
	private MongoTemplate mongoTemplate;

	/**
	 * @param Employee Object
	 * @return boolean true if employee details added to DB.
	 *
	 */
	@Override
	public boolean save(Employee employee) {
		boolean saved = true;
		try {
			LOGGER.info("In DAL, Saving Employee - {}", employee);
			mongoTemplate.save(employee, "Employee");
		} catch (Exception ex) {
			LOGGER.error("In DAL, Error while saving employee - {}", ex);
			saved = false;
		}
		return saved;
	}

	/**
	 *@param 
	 *@return List of EMployees sorted by first name.
	 */
	@Override
	public List<Employee> getAll() {
		try {
			LOGGER.info("In DAL, fetching Employee List");
			Query query = new Query();
			query.with(new Sort(Sort.Direction.ASC, "firstName"));
			return mongoTemplate.find(query, Employee.class);

		} catch (Exception ex) {
			LOGGER.error("In DAL, error occured while fetching Employee List - {}", ex);
		}
		return null;
	}

}
