package com.capgemini.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.capgemini.model.Employee;

public class EmployeeMapper implements RowMapper<Employee>
{
	
	public Employee mapRow(ResultSet rs, int number) throws SQLException {

		Employee emp= new Employee();
		emp.setEmpId(rs.getInt(1));
		emp.setEmpName(rs.getString(2));
		emp.setEmpSalary(rs.getFloat(3));
		return emp;
	}

}
