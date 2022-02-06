package com.renji.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.renji.model.Employee;

public class EmployeeMapper implements RowMapper<Employee> {

	public Employee mapRow(ResultSet rs, int rows) throws SQLException {
		Employee emp = new Employee();
		
		emp.setId(rs.getInt("id"));
		emp.setAddress(rs.getString("empaddress"));
		emp.setAge(rs.getInt("empAge"));
		emp.setName(rs.getString("empname"));
		emp.setSalary(rs.getLong("salary"));
		
		return emp;
	}

}
