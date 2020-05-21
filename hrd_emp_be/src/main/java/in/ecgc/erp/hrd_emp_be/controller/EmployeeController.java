package in.ecgc.erp.hrd_emp_be.controller;

import java.util.List;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

//import org.slf4j.Logger;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


import in.ecgc.erp.hrd_emp_be.model.*;
import in.ecgc.erp.hrd_emp_be.service.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;


/**
 *Employee Controller class
 *
 *@version 1.0 31-March-20
 *@Author Architecture Team C-DAC Mumbai
 **/
@RestController
@RequestMapping("/")
@Api(value = "Employee Management System", 
     description = "Operations pertaining to employee in Employee Management System")//Swagger annotation
public class EmployeeController {

	private static final Logger LOGGER=LoggerFactory.getLogger(EmployeeController.class);

	@Autowired
	private EmployeeService empService;

	
	/**
	   * Save Employee Data into Employee Master
	   * 
	   * @param employee   Employee employee-object
	   * @return result    result will be boolean type (true/false)
	*/
	@ApiOperation(value = "Save an employee")						//Swagger Annotation 
	@PostMapping("/saveEmployeeData")
	public boolean saveEmployeeData(@RequestBody Employee employee,Locale locale, Model model) {

		LOGGER.info("--Inside save employee data--");
		LOGGER.error("--Creating Employee with this data--",employee);
		boolean result = empService.addEmployee(employee);
	    return result;
	}
	
	
	  /**
     * Returns List of Employees
     *
     * @param EmpID			Employee Employee Id
     * @param FirstName     Employee First Name
     * @param Designation	Employee Designation
     * @param Employee_type Employee Type
     * @return
     */
    @ApiOperation(value = "View a list of available employees", response = List.class)   	//Swagger Annotation
	@GetMapping("/allEmployeeData")
	public List<Employee> getAllEmployees(){
		LOGGER.info("--Inside Get all employees--");
		LOGGER.error("--Fetching Employee data--");
		List<Employee> employeeList=empService.getAllEmployees();
		System.out.println(employeeList);
		return employeeList;
	}
	
    
    /**
     * Delete Employee with particular ID
     *
     * @param EmpID			Employee Employee Id
     * @return				1 for true 0 for false
     */
    @ApiOperation(value = "Delete an employee")								//Swagger Annotation
	@GetMapping("/deleteEmployee/{id}")
	public int deleteEmployee(@ApiParam(value = "Employee Id from which employee object will delete from database table", required = true)
	                          @PathVariable("id") Integer empId){
		LOGGER.info("--Inside Delete Employee--");
		LOGGER.info("--Deleting Employee Data--");
		int result=empService.deleteEmployee(empId);
		return result;
	}
	
    //Note Swagger Annotation @Api, @ApiOperation ,@ApiParam etc.
}
