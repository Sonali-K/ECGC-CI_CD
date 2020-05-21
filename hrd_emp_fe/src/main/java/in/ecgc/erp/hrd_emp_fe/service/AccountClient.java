package in.ecgc.erp.hrd_emp_fe.service;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name = "acc-inv-be")
public interface AccountClient {

	/*
	 * Method are written here in which we want to call from Account Module and map it
	 * into controller same as 'Employee Client'.
	 */
	
	/*
	 * Note: For different module call from one service we have to create multiple
	 *       interface with FeignClient 
	 */ 
}
