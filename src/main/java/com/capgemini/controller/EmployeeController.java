package com.capgemini.controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.model.Employee;

@RestController
public class EmployeeController {

	List <Employee> allEmployee= new ArrayList<Employee>();
	
	public EmployeeController(){
		
		Employee employee = new Employee();
		employee.setEmpId(101);
		employee.setEmpName("Giri");
		employee.setEmpSalary(45000);
		
		allEmployee.add(employee);
	}
	
	@RequestMapping(value="/cg/{id}",method=RequestMethod.GET,produces=MediaType.APPLICATION_XHTML_XML_VALUE)
	public Employee getEmployeeById(@PathVariable("id") int empId){
		Employee searchResults = null;
		for(Employee emp:allEmployee){
			
			if(emp.getEmpId() == empId)
			{
				searchResults=emp;
				break;
			}
		}
		return searchResults;
	}
	
	@RequestMapping(value="/getempinjson/{id}",method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
	public Employee getEmployeeByIdInJSON(@PathVariable("id") int empId){
		Employee searchResults = null;
		for(Employee emp:allEmployee){
			
			if(emp.getEmpId() == empId)
			{
				searchResults=emp;
				break;
			}
		}
		return searchResults;
	}
	
	// it will retrun any type of response which represents as ? anything 
	@RequestMapping(value="/addemp",method=RequestMethod.POST)
	public ResponseEntity<?> addEmployeeInJSON(@RequestBody Employee employee){
		
		allEmployee.add(employee);
		System.out.println("Object is added in collection");
		System.out.println("Object  Size is = "+allEmployee.size());
		return ResponseEntity.ok().body("Object is added in collection");
		
	}
	
	
	//show all employee records
	
	@RequestMapping(value="/showEmp",method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Employee> showEmployee(){
		
		List <Employee> emplist = new ArrayList<Employee>();
		
		if(allEmployee.size()!=0){
			emplist=(List<Employee>) allEmployee;
		}
		
		/*for(Employee emp : allEmployee)
		{
			System.out.println("employee-->");
			empl.add(emp);
		}
		*/
		return emplist;
	}
	
	// it will retrun any type of response which represents as ? anything 
		@RequestMapping(value="/deleteemp/{id}",method=RequestMethod.GET)
		public ResponseEntity<?> addEmployeeInJSON(@PathVariable("id") int eid){
			
			Iterator<Employee> it= allEmployee.iterator();
			while(it.hasNext()){
				Employee e = it.next();
				if(e.getEmpId() == eid)
				{
					it.remove();
					break;
				}
			}
			return ResponseEntity.ok().body("Object is removed in collection");
		}
}
