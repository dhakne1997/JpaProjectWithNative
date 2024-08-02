package com.Employee.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.Employee.model.EmployeeModel;
import com.Employee.service.EmployeeService;

import org.springframework.data.domain.Sort;


@RestController
public class EmployeeController {
	@Autowired
	private EmployeeService employeeService;
	
	/**
	 * GET Employee Details
	 *
	 */
	@GetMapping("/emp")
 public List<EmployeeModel>getEmployeeModels()
	{
		return this.employeeService.getEmployeeModels();
	}
	
	/**
	 *Add Employee Details
	 *
	 */
	@PostMapping("/Empadd")
	public EmployeeModel addEmployeeModel(@RequestBody EmployeeModel employeeModel)
	{
		return this.employeeService.addEmployeeModel(employeeModel);
	
	}
	
	
	
	
	
	/**
	 * Update Employee Details
	 *
	 */
	@PutMapping("/EmpUpdate")
public EmployeeModel updateEmployeeModel(@RequestBody EmployeeModel employeeModel)
		
{
return employeeService.updateEmployeeModel(employeeModel);

}

	/**
	 * Springboot jpa using query
	 */
	
	@GetMapping("/e")
	 public List<EmployeeModel> findByEmployeeName(@RequestParam("name") String employeeName)
		{
			return this.employeeService.findByEmployeeName(employeeName);
		}

	/**
	 * Springboot jpa using query multiple column entry
	 */

	@GetMapping("/e1")
	 public List<EmployeeModel> findByEmployeeNameAndEmployeeRole(@RequestParam("name") String employeeName,@RequestParam("surname") String employeeSurname)
		{
			return this.employeeService.findByEmployeeNameAndEmployeeRole(employeeName,employeeSurname);
		}
	
	
	/**
	 * Springboot jpa using query
	 */
	@GetMapping("/e2")
	 public List<EmployeeModel> findByEmployeeOrg(@RequestParam("orgname") String companyName)
		{
			return this.employeeService.findByEmployeeOrg(companyName);
		}

	
	@GetMapping("/e3")
public List<EmployeeModel>findByEmployeeAddress(@RequestParam("fname")String firstName,@RequestParam("address")String address)
{
		return this.employeeService.findByEmployeeAddress(firstName,address);
}
	
	
	
	//Pagination
	
	@GetMapping("/page")
	public ResponseEntity<Page<EmployeeModel>> getPaging(@PageableDefault( sort = "empId", direction = Sort.Direction.ASC) Pageable pageable) {
	    return this.employeeService.findByPaging(pageable);
	    
	    
	    
	}
}