package in.ecgc.erp.hrd_emp_fe.controller;



import java.util.List;
import java.util.Locale;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import in.ecgc.erp.hrd_emp_fe.dto.EmployeeInput;


import in.ecgc.erp.hrd_emp_fe.service.EmployeeClient;



/**
 *Employee FE Controller class
 *
 *@version 1.0 31-March-20
 *@Author Architecture Team C-DAC Mumbai
 **/
@Controller
@RequestMapping("/")
@CrossOrigin(allowedHeaders = "*")
public class HrdEmpFeController {
	
	private static final Logger LOGGER=LoggerFactory.getLogger(HrdEmpFeController.class);
	
	@Autowired
	private EmployeeClient empClient;
	
	
	@GetMapping(value= {"/","Dashboard"})
	public String dashboard() {
		System.out.println("Inside Home Controller With SM dashboard");
		return "dashboard";
	}
	
	
	
	 /**
     * Returns Employees
     *
     * @param EmpID			Employee Employee Id
     * @param FirstName     Employee First Name
     * @param Designation	Employee Designation
     * @param Employee_type Employee Type
     * @return
     */

	@GetMapping(value = "/hrd")
	public String Index(Model model,Locale locale) {
	LOGGER.info("--DASHBOARD--");

		System.out.println("\n\n---------------------\n"+empClient);
		List<EmployeeInput> emp=empClient.getAllEmployees();
		System.out.println(emp);
		model.addAttribute("listEmployee",emp);
		
		return "allEmployees";
	}
	
	
	@GetMapping(value = "/employeeProfileCreation")
	public String requestPoReimburse(Locale locale, Model model) {		
		LOGGER.info("--Employee Creation--");
		model.addAttribute("employee", new EmployeeInput());
		return "employeeProfileCreation";
	}
	
	/**
	   * Save Employee Data into Employee Master
	   * @param employee   EmployeeInput employee-object
	   * @return 
	*/
	@HystrixCommand(fallbackMethod = "fallback")
	@PostMapping(value = "/saveEmployeeData")
	public String saveEmployeeData(@ModelAttribute("employee") @Valid EmployeeInput employee,BindingResult errors, Locale locale,Model model){
		
		if(errors.hasErrors()) {
			System.out.println(errors);
			model.addAttribute("employee", employee);
			//model.addAttribute("errors",errors);
			return "employeeProfileCreation";
		}
		
		LOGGER.info("--Save Employee Credentail--");
		LOGGER.info("--Employee data for Saving --",employee);
        boolean result=empClient.addEmployee(employee);
        System.out.println(result);
		
		return "redirect:/hrd";
		
	}

	
	/**
	 * Method for delete employee
	 * @PathVariable empid
	 * @return integer
	 * */
	@GetMapping(value = "/deleteEmployee/{id}")
	public String deleteEmployeeData(@PathVariable("id") Integer empId,Locale locale,Model model) {
		LOGGER.info("--Delete Employee Credentail--");
		LOGGER.info("--Deleting Employee Data --",empId);
		
		int result =empClient.deleteEmployee(empId);
		return "redirect:/hrd";
		
	}
	
	
	//Format for datatable
	@GetMapping("/datatable")
	public String datatables() {
		System.out.println("Inside Home Controller With SM datatable");
		return "datatable";
	}

	//Format for Buttons
	@GetMapping("/buttons")
	public String buttons() {
		System.out.println("Inside Home Controller With SM buttons");
		return "buttons";
	}

	//Format for Form Elements
	@GetMapping("/formelements")
	public String formelements() {
		System.out.println("Inside Home Controller With SM formelements");
		return "formelements";
	}

	
	@GetMapping("/deatailedtable")
	public String detailtable() {
		System.out.println("Inside Home Controller With SM detaileddatatable");
		return "deatailedtable";
	}

	//Format for Alerts
	@GetMapping("/alert")
	public String alert() {
		System.out.println("Inside Home Controller With SM alert");
		return "alert";
	}

	//Loader
	@GetMapping("/loader")
	public String loader() {
		System.out.println("Inside Home Controller With SM loader");
		return "loader";
	}
	
	@GetMapping("/userProfile")
	public String userProfile() {
		System.out.println("Inside Home Controller With SM loader");
		return "userprofile";
	}
	
	
	public String fallback(@ModelAttribute("employee") @Valid EmployeeInput employee,BindingResult errors, Locale locale,Model model,Throwable throwable) {
		
		 System.out.printf("Default exception=%s%n",throwable);
		
		if(errors.hasErrors()) {
			System.out.println(errors);
			model.addAttribute("employee", employee);
			//model.addAttribute("errors",errors);
			return "employeeProfileCreation";
		}
		
		LOGGER.info("--Save Employee Credentail--");
		LOGGER.info("--Employee data for Saving --",employee);
        boolean result=empClient.addEmployee(employee);
        System.out.println(result);
		
		return "redirect:/hrd";
		
	}
	
}














 
  
 