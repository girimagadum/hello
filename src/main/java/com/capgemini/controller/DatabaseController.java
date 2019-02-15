package com.capgemini.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.model.Employee;
import com.capgemini.service.EmployeeService;

@RestController
public class DatabaseController {
	
	@Autowired
	EmployeeService empService;
	
	
	@GetMapping(value="getbyid/{id}",produces=MediaType.APPLICATION_JSON_VALUE)
	public Employee getDataById(@PathVariable("id") int empid){
		return empService.getEmployeeeByID(empid);
	
	}
	
	@GetMapping(value="getEmployees",produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Employee> getAllEmployee(){
		return empService.getAllEmployee();
	
	}
	
	@GetMapping(value="deleteEmployee/{id}",produces=MediaType.APPLICATION_JSON_VALUE)
	public int deleteEmpById(@PathVariable("id") int empid){
		return empService.deleteEmployeeById(empid);
	
	}
	
/*	@PostMapping(value="addEmployee",produces=MediaType.APPLICATION_JSON_VALUE)
	public int insertEmployee(Employee emp){
		return empService.insertEmployee(emp.setEmpId(103), emp.setEmpName("Ajay"), emp.setEmpSalary((float) 56000.0));
	
	}*/

}
