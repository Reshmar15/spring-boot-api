package com.example;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.example.bean.Employee;

@Component
@RestController

public class EmployeeController {
	private static final String apiDomain = "https://jsonplaceholder.typicode.com/";
	
	 @RequestMapping(value ="/", method = RequestMethod.GET)
	    public String home(){
	        return "Welcome!";
	    }
	
	@RequestMapping(value = "/employee/{id}", method = RequestMethod.GET)
	public Employee getEmployee(@PathVariable("id") int id) {
		
		RestTemplate restTemplate = new RestTemplate();
		final Employee responseBody = restTemplate.getForObject(apiDomain + "posts/"+ id,
				Employee.class);
		return responseBody;
	}
	
	@RequestMapping(value = "/allemployes", method = RequestMethod.GET)
	public Employee[] getAllEmployees() {
		
		RestTemplate restTemplate = new RestTemplate();
		final ResponseEntity<Employee[]>  responseBody =  restTemplate.getForEntity(apiDomain + "posts/",
				Employee[].class);
		return responseBody.getBody();
	}

}
