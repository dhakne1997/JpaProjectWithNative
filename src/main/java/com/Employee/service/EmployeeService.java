package com.Employee.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

import com.Employee.model.EmployeeModel;

public interface EmployeeService {

public 	List<EmployeeModel> getEmployeeModels();

public 	EmployeeModel addEmployeeModel(EmployeeModel employeeModel);

public 	EmployeeModel updateEmployeeModel(EmployeeModel employeeModel);


List<EmployeeModel> findByEmployeeName(String employeeName);


public List<EmployeeModel> findByEmployeeNameAndEmployeeRole(String employeeName, String employeeSurname);

 List<EmployeeModel> findByEmployeeOrg(String companyName);

public List<EmployeeModel> findByEmployeeAddress(String firstName, String address);

public ResponseEntity<Page<EmployeeModel>> findByPaging(Pageable pageable);


}
