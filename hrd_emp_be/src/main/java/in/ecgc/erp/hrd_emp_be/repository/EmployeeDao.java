package in.ecgc.erp.hrd_emp_be.repository;

import java.util.List;

import in.ecgc.erp.hrd_emp_be.model.Employee;

/**
 * Employee Repository interface
 * 
 * @Author Architecture Team C-DAC Mumbai
 */
public interface EmployeeDao {

	/* Method for saving Employee Data */
	public int saveEmployeeData(Employee employee);
	
	/* Method for Fetching All Employee Data */
	public List<Employee> allEmployeeData();
	
	/* Method for delete particular Employee By Emp_ID */
	public int deleteEmployee(Integer emp_id);
}
