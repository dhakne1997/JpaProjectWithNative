package com.Employee.serviceImpl;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.Employee.dao.EmployeeDao;
import com.Employee.model.EmployeeModel;
import com.Employee.service.EmployeeService;
@Service
public class EmployeeServiceImpl implements EmployeeService{
	@Autowired
	private EmployeeDao employeeDao;
	
	
	@Override
	public List<EmployeeModel> getEmployeeModels() {
		return (List<EmployeeModel>)employeeDao.findAll();
	}

	@Override
	public EmployeeModel addEmployeeModel(EmployeeModel employeeModel) {
		return employeeDao.save(employeeModel);
		 
	}

	@Override
	public EmployeeModel updateEmployeeModel(EmployeeModel employeeModel) {
		return employeeDao.save(employeeModel);
		
		

	 
	  }
	
	/**
	 * Springboot jpa using query
	 */
	@Override
	public List<EmployeeModel> findByEmployeeName(String employeeName) {
		return employeeDao.findByNameNative(employeeName);
	}

	/**
	 * Springboot jpa using query multiple column entry
	 */
	@Override
	public List<EmployeeModel> findByEmployeeNameAndEmployeeRole(String employeeName, String employeeSurname) {
		return employeeDao.findByEmployeeNameAndEmployeeRole(employeeName,employeeSurname);
	}

	/**
	 * Springboot jpa using query
	 */
	@Override
	public List<EmployeeModel> findByEmployeeOrg(String companyName) {
		// TODO Auto-generated method stub
		return employeeDao.findByNameNative1(companyName);
	}

	@Override
	public List<EmployeeModel> findByEmployeeAddress(String firstName, String address) {
		
		return employeeDao.findByNameOrAddress(firstName,address);
	}

	@Override
	public ResponseEntity<Page<EmployeeModel>> findByPaging(Pageable pageable) {
		Page<EmployeeModel>pageBook=employeeDao.findAll(pageable);
		return ResponseEntity.ok(pageBook);
	}

	

	}




