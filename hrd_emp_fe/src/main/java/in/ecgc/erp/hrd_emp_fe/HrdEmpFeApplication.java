package in.ecgc.erp.hrd_emp_fe;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/*HRD-FE-Service
 * 
 * @Author Architecture Team C-DAC Mumbai
 * 
 */
@SpringBootConfiguration
@SpringBootApplication
@EnableDiscoveryClient	// To register with Eureka Server
@EnableFeignClients     // Enable FeignClients for calling other service
@EnableCircuitBreaker   // Enable Circuit breaker via Hystrix
public class HrdEmpFeApplication {

	public static void main(String[] args) {
		SpringApplication.run(HrdEmpFeApplication.class, args);
	}
	
	
}
