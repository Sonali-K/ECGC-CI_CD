package in.ecgc.erp.hrd_emp_fe.service;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PathVariable;

import in.ecgc.erp.hrd_emp_fe.dto.EmployeeInput;


/**
 *Employee client interface
 *used for calling BE Microservice
 *
 *@version 1.0 31-March-20
 *@Author Architecture Team C-DAC Mumbai
 *
 **/
@FeignClient(name = "hrd-emp-be",url="http://10.212.0.72:8083/")
public interface EmployeeClient {
	
	//Get all Employee Data : From BE Service
	@GetMapping("/allEmployeeData")
	public List<EmployeeInput> getAllEmployees();

	//Save Employee Data :through BE Service
	@PostMapping("/saveEmployeeData")
	public boolean addEmployee(EmployeeInput employee);
	
	//Delete Employee Data : through BE Service
	@GetMapping("/deleteEmployee/{id}")
	public int deleteEmployee(@PathVariable("id") Integer empId);
}
