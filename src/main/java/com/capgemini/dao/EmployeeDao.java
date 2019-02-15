package com.capgemini.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.capgemini.mapper.EmployeeMapper;
import com.capgemini.model.Employee;

@Repository
public class EmployeeDao {
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	

	public Employee  getEmployeeById(int empid){
		
		String sqlquery="Select * from cgemployee where emp_id=?";
		
		return jdbcTemplate.queryForObject(sqlquery,new Object[] {empid},new EmployeeMapper());
		
	}
	
	public List<Employee> getAllEmployee(){
		
		String sql="select * from cgemployee";
		
		return jdbcTemplate.query(sql, new EmployeeMapper());
		
	}
	
	
	public int  deleteEmployeeById(int empid){
		
		String sqlquery="delete from cgemployee where emp_id=?";
		
		return jdbcTemplate.update(sqlquery,new Object[] {empid},new EmployeeMapper());
		
	}
	
/*	public int insertEmployee(Employee emp){
		
		String insertSql="insert into cgemployee values(?,?,?)";
		int updaterows = jdbcTemplate.update(insertSql,new Object[] {emp.getEmpId(),emp.getEmpName(),emp.getEmpSalary()},new EmployeeMapper());
		return updaterows;
	}*/


	
}
