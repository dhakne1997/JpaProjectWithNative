package com.Employee.dao;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.Employee.model.EmployeeModel;
@Repository
@Transactional
public interface EmployeeDao extends JpaRepository<EmployeeModel, Long>{
	/**
	 * Springboot jpa using query
	 */
	  @Query("from EmployeeModel  where empFirstName =:name ")

	  List<EmployeeModel> findByNameNative(@Param("name") String name);      // using method
	    
//	    @Query(value = "SELECT * from employee_model  where emp_first_name =:parag ", nativeQuery = true)   
//	    List<EmployeeModel> findByNameNative(@Param("parag") String parag);
//	


	  /**
		 * Springboot jpa using query multiple column entry using AND
		 */
//List<Employee> findByEmployeeNameAndEmployeeRole(@Param("name")String name,@Param("role") String role);
//@Query("SELECT * from employee_model  where emp_first_name =:parag AND emp_last_name=:maske")
//List<Employee> findByNameAndRole(@Param("name") String name,@Param("role")String role);
@Query(value = "SELECT * from employee_model  where emp_first_name =:name AND emp_last_name=:namename ", nativeQuery = true)
List<EmployeeModel> findByEmployeeNameAndEmployeeRole(@Param("name") String name, @Param("namename")String namename);


/**
 * Springboot jpa using query
 */
@Query(value = "SELECT * from employee_model  where emp_organization =:orgname ", nativeQuery = true)   
List<EmployeeModel> findByNameNative1(@Param("orgname") String companyName);

/**
 * Springboot jpa using query multiple column entry using OR
 */

//List<EmployeeModel> findByEmployeeNameOrEmployeeRole(@Param("name")String name,@Param("role") String role);
@Query(" from EmployeeModel where emp_first_name =:fname or empaddress =:address")
List<EmployeeModel> findByNameOrAddress(@Param("fname") String parag,@Param("address")String pune);

//@Query(value = "SELECT * from Employee e where e.employeeName =:name or e.employeeRole = :role ", nativeQuery = true)
//List<EmployeeModel> findByNameOrRoleNative(@Param("name") String name, @Param("role")String role);

}


