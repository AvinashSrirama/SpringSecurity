package com.howtodoinjava.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.howtodoinjava.demo.model.Employee;

@RestController
public class EmployeeController {
	
	@RequestMapping("/hello")
    public String helloWorld()
    {
		return "Hello World";
    }

	//@Secured("ROLE_USER")
	@PreAuthorize("hasRole('ROLE_VIEWER')")
	@RequestMapping("/getEmployee")
	public List<Employee> getEmployees()
	{
		List<Employee> employeesList = new ArrayList<Employee>();
		employeesList.add(new Employee(1,"Avinash","Srirama","srirama.avinash@gmail.com"));
		return employeesList;
	}

}
