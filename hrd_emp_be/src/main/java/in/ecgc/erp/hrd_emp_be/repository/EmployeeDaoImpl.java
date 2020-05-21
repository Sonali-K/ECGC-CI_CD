package in.ecgc.erp.hrd_emp_be.repository;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcOperations;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import in.ecgc.erp.hrd_emp_be.model.Employee;
import in.ecgc.erp.hrd_emp_be.util.EmployeeQueries;



/**
 * Employee Repository implementation
 * @version 1.0 31-March-20
 * @Author Architecture Team C-DAC Mumbai
 */
@Repository
public class EmployeeDaoImpl implements EmployeeDao {
	
	
	private JdbcOperations jdbcOperations;
	
	/* For parameterized query */
	private NamedParameterJdbcOperations namedParameterJdbcOperations;
	
	/*Constructor for autowire jdbc and datasource*/
	@Autowired
	public EmployeeDaoImpl(DataSource dataSource) {
		jdbcOperations = new JdbcTemplate(dataSource);
		namedParameterJdbcOperations = new NamedParameterJdbcTemplate(dataSource);
		
	}
	
	/* Method for fetching all employee data */
	public List<Employee> allEmployeeData() {
		List<Employee> employee=jdbcOperations.query(EmployeeQueries.GET_ALL_EMPLOYEES,new RowMapper<Employee>() {

			@Override
			public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
				Employee employee=new Employee(); 
				employee.setEmpId(rs.getInt("emp_id"));
				employee.setFirstName(rs.getString("emp_fname"));
				employee.setLastName(rs.getString("emp_lname"));
				employee.setDob(rs.getString("dob"));
				employee.setDoj(rs.getString("doj"));
				return employee;
			}
		});
		return employee;
	}
	
	/* Method for saving employee data */
	public int saveEmployeeData(Employee employee) {
		
		System.out.println(employee);
		  Date dob=Date.valueOf(employee.getDob());//converting string into sql date
		  Date doj=Date.valueOf(employee.getDoj());//converting string into sql date
		  Map<String, Object> namedParameters = new HashMap<String, Object>();
		  namedParameters.put("empId", employee.getEmpId());
		  namedParameters.put("firstName", employee.getFirstName());
		  namedParameters.put("midName", employee.getMidName());
		  namedParameters.put("lastName", employee.getLastName());
		  namedParameters.put("DOB", dob); namedParameters.put("DOJ", doj);
		  namedParameters.put("empType", employee.getEmpType());
		  namedParameters.put("designation", employee.getDesignation()); 
		  try { 
			  int result =namedParameterJdbcOperations.update(EmployeeQueries.INSERT_EMPLOYEE_RECORD,namedParameters); 
			  return result; 
		  }catch(Exception e) { 
			  System.out.println(e);
			 
			  e.printStackTrace(); 
		  }
		 
		return 0;
		
	}

	/* Method for fetching all employee data */
	public List<Employee> viewEmployeeData(int emp_id){
		List<Employee> employeeList=jdbcOperations.query(EmployeeQueries.GET_EMPLOYEE_BY_ID,
				new Object[] { emp_id }, new RowMapper<Employee>() {
			@Override
			public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
				Employee employee = new Employee();
				employee.setEmpId(rs.getInt("emp_id"));
				employee.setFirstName(rs.getString("emp_fname"));
				employee.setFirstName(rs.getString("emp_mname"));
				employee.setFirstName(rs.getString("emp_lname"));
				employee.setDob(rs.getString("dob"));
				employee.setDoj(rs.getString("doj"));
				employee.setDesignation(rs.getString("designation"));
				return employee;
			}
		});
		return employeeList;
	}
	
	/* Method for deleting employee with EMP_ID */
	public int deleteEmployee(Integer emp_id) {
		
		System.out.println(EmployeeQueries.DELETE_EMPLOYEE+" "+emp_id+"\n\n\n\n");
		int result=jdbcOperations.update(EmployeeQueries.DELETE_EMPLOYEE,emp_id);
		return result;
	}
	
	

}
