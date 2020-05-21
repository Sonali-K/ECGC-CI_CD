package in.ecgc.erp.hrd_emp_be;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import in.ecgc.erp.hrd_emp_be.model.Employee;

public class JsonConverter {
	
	
	public static String asJsonString(final Object obj) {
		try {
			ObjectMapper objectMapper = new ObjectMapper();
			objectMapper.registerModule(new JavaTimeModule());
			objectMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
			return objectMapper.writeValueAsString(obj);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	public static void main(String[] args) {
		Employee emp = new Employee();
		emp.setFirstName("Sonali");
		emp.setLastName("K");
		System.out.println(asJsonString(emp));
	}

}
