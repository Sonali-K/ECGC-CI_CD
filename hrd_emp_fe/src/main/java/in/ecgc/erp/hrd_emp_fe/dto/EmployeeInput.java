package in.ecgc.erp.hrd_emp_fe.dto;


import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.Data;
/**
 *Employee Input DTO class
 *
 *@version 1.0 31-March-20
 *@Author Architecture Team C-DAC Mumbai
 *
 **/
//@Data
public class EmployeeInput {
	
	/* Employee Id which is used for Employee reference */
	@NotNull(message = "Employee must required !")
	int empId;
	
	/* Employee First Name*/
	@NotBlank(message="Please provide First Name")
	String firstName;
	
	/* Employee Middle Name*/
	@NotBlank(message="Please provide Middle Name")
	String midName;
	
	/* Employee Last Name*/
	@NotBlank(message="Please provide Last Name")
	String lastName;
	/* Employee DOB*/
	@NotBlank(message="Please provide Date of Birth")
	String dob;
	
	/* Employee Date of joining*/
	@NotBlank(message="Please provide Date of Joining")
	String doj;
	
	/* Employee Type*/
	@NotBlank(message="Please provide Employee Type")
	String empType;
	
	/* Employee designation*/
	@NotBlank(message="Please provide Designation of Employee")
	String designation;

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getMidName() {
		return midName;
	}

	public void setMidName(String midName) {
		this.midName = midName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getDoj() {
		return doj;
	}

	public void setDoj(String doj) {
		this.doj = doj;
	}

	public String getEmpType() {
		return empType;
	}

	public void setEmpType(String empType) {
		this.empType = empType;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}
	
	
	
}

