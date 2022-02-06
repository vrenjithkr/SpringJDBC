package com.renji.dao;

import java.util.List;

import com.renji.model.Employee;

public interface EmployeeDao {
	
	public void saveEmployee(Employee employee);
	public List<Employee> getAllEmployees();
	public Employee getEmployee(int id);
	public void deleteEmployee(int id);
	public void updateEmployee(Employee employee,int employeeId);

}
