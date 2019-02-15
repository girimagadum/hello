package com.capgemini.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.dao.EmployeeDao;
import com.capgemini.model.Employee;

@Service
public class EmployeeService {
	
	@Autowired
	EmployeeDao empDao;
	
	public Employee getEmployeeeByID(int empid){
		
		return empDao.getEmployeeById(empid);
	}

	public List<Employee> getAllEmployee(){
		
		return empDao.getAllEmployee();
		
	}
	
	public int deleteEmployeeById(int empid){
		return empDao.deleteEmployeeById(empid);
	}
	
/*	public int insertEmployee(Employee emp){
		
		return empDao.insertEmployee(emp.getEmpId(),emp.getEmpName(),emp.getEmpSalary());
	}*/
}
