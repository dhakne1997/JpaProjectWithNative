package com.AngularStudent;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;

import com.Employee.model.EmployeeModel;

@SpringBootTest
class CompanyJpaProjectApplicationTests {

	@Test
	void contextLoads() {
	}

	
	@LocalServerPort
	private int port;

	@Autowired
	private TestRestTemplate restTemplate;

	@Test
	public void shouldReturnSomeData() throws Exception {
		
		this.restTemplate.getForObject("http://localhost:" + port + "/",
				List.class);
		
	}
}
