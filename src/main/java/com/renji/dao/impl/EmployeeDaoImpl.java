package com.renji.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.renji.dao.EmployeeDao;
import com.renji.mapper.EmployeeMapper;
import com.renji.model.Employee;

@Component
public class EmployeeDaoImpl implements EmployeeDao{
	
	@Autowired
	JdbcTemplate jdbcTemplateObject;

	@Override
	public void saveEmployee(Employee employee) {
		String SQL = "INSERT INTO `Employee`(`empaddress`, `empAge`, `empname`, `salary`) VALUES (?,?,?,?)";
		jdbcTemplateObject.update(SQL, employee.getAddress(), employee.getAge(), employee.getName(),
				employee.getSalary());
	}
	
	@Override
	public void updateEmployee(Employee employee, int employeeId) {
		String SQL = "update Employee set empname = ? , empAge = ? , empaddress = ? , salary = ? where id = ?";  //Create a SQL sentence 
		jdbcTemplateObject.update(SQL,  employee.getName(), employee.getAge(),employee.getAddress(),employee.getSalary(),employeeId);
	}

	@Override
	public List<Employee> getAllEmployees() {
		String sql = "select * from Employee";
		List<Employee> list = jdbcTemplateObject.query(sql, new EmployeeMapper());
		return list;
	}

	@Override
	public Employee getEmployee(int empid) {

		String sql = "SELECT * FROM `Employee` WHERE `id` = ?";
		Employee Employee = jdbcTemplateObject.queryForObject(sql, new Object[] { empid },
				new EmployeeMapper());
		return Employee;
	}


	@Override
	public void deleteEmployee(int id) {
		String SQL = "delete from Employee where id = ?";
		jdbcTemplateObject.update(SQL, id);
		
	}

}
