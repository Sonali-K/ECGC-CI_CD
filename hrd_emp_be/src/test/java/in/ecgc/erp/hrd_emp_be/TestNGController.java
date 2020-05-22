package in.ecgc.erp.hrd_emp_be;

import static in.ecgc.erp.hrd_emp_be.JsonConverter.asJsonString;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.context.WebApplicationContext;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import in.ecgc.erp.hrd_emp_be.model.Employee;

@SpringBootTest(classes = HrdEmpBeApplication.class)
public class TestNGController extends AbstractTestNGSpringContextTests {
	
	@Autowired
	private WebApplicationContext webApplicationContext;

	//@Autowired
	private MockMvc mockMvc;

	@BeforeClass
	public void setup() {
		
		mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
	}

	
	
	@Test
	@Order(3)
	public void viewAllEmployees() {
		try {
			mockMvc.perform(MockMvcRequestBuilders.get("/allEmployeeData").contentType(MediaType.APPLICATION_STREAM_JSON))
			.andExpect(status().isOk())
			.andExpect(MockMvcResultMatchers.jsonPath("$").isNotEmpty());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
	@Test
	@Order(1)
	public void addEmployee() throws Exception {
		Employee emp = new Employee();
		emp.setEmpId(6);
		emp.setFirstName("Arun");
		emp.setLastName("K");
		emp.setDob("1999-9-9");
		emp.setDoj("1995-8-8");
		System.out.println(asJsonString(emp));
		
		mockMvc.perform(MockMvcRequestBuilders.post("/saveEmployeeData")
				.contentType(MediaType.APPLICATION_STREAM_JSON)
				.content(asJsonString(emp)))
		.andExpect(status().isOk())
		.andExpect(MockMvcResultMatchers.jsonPath("$").isNotEmpty());
	}
	
	@Test
	@Order(2)
	public void deleteEmployee() throws Exception {
		//Employee emp = new Employee();
		//emp.setEmpId(9);
			mockMvc.perform(MockMvcRequestBuilders.get("/deleteEmployee/6")
				.contentType(MediaType.APPLICATION_STREAM_JSON))
			//.content(asJsonString(emp)))
		.andExpect(status().isOk())
		.andExpect(MockMvcResultMatchers.jsonPath("$").value(1));
		
		
	}

	
} 