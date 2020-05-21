package in.ecgc.erp.hrd_emp_be.service;

import java.util.List;

import org.springframework.stereotype.Service;
import in.ecgc.erp.hrd_emp_be.model.Employee;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


/**
 * Employee Service interface
 * @version 1.0 31-March-20
 * @Author Architecture Team C-DAC Mumbai
 */
@Service
@EnableSwagger2
public interface EmployeeService {
	
	/**
	   * Add new Employee to the Employee Master.
	   *
	   * @param employee      Employee employee
	   * @return result       which is boolean value
	*/	
	public boolean addEmployee(Employee employee);

	
	/**
	   * Request for fetch all Employees
	   * 
	   * @return A list of employees
	*/	
	public List<Employee> getAllEmployees();
	
	
	/**
	   * Delete particular Employee 
	   * 
	   * @param emp_id  Employee empId
	   * @return result 1 for true 0 for false
	*/
	public int deleteEmployee(Integer emp_id);
}
