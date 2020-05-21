package in.ecgc.erp.hrd_emp_be.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import in.ecgc.erp.hrd_emp_be.model.Employee;
import in.ecgc.erp.hrd_emp_be.repository.EmployeeDao;



/**
 * Employee Service implementation
 *  
 * @version 1.0 31-March-20
 * @Author Architecture Team C-DAC Mumbai
 */
@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired(required = true)
	private EmployeeDao dao;
	
	public EmployeeDao getDao() {
		return dao;
	}

	public void setDao(EmployeeDao dao) {
		this.dao = dao;
	}

	
	@Override
	public boolean addEmployee(Employee employee) {
		int result = getDao().saveEmployeeData(employee);
		if(result==1) {
			return true;
		}
		return false;
	}
	/*
	 * @Override public List<Employee> findEmployee(int empId) { List<Employee>
	 * result=; return result; }
	 */

	@Override
	public List<Employee> getAllEmployees() {
		List<Employee> employee=getDao().allEmployeeData();
		return employee;
	}

	@Override
	public int deleteEmployee(Integer emp_id) {
		int result =getDao().deleteEmployee(emp_id);
		return result;
	}



}
