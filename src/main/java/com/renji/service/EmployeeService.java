package com.renji.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.renji.dao.impl.EmployeeDaoImpl;
import com.renji.model.Employee;

@Service
public class EmployeeService {

	@Autowired
	EmployeeDaoImpl employeeDao;

	public List<Employee> getAllemployees() {
		List<Employee> employees = employeeDao.getAllEmployees();
		return employees;
	}

	public Employee getemployee(int employeeId) {
		return employeeDao.getEmployee(employeeId);
	}

	public Employee saveEmployee(Employee employee) {
		employeeDao.saveEmployee(employee);
		return null;
	}

	public Employee updateEmployee(int employeeId, Employee employee) {
		Employee ExistingEmployee = employeeDao.getEmployee(employeeId);
		if (null != employee.getName()) {
			ExistingEmployee.setName(employee.getName());
		}
		if (null != employee.getAge()) {
			ExistingEmployee.setAge(employee.getAge());
		}
		if (null != employee.getAddress()) {
			ExistingEmployee.setAddress(employee.getAddress());
		}
		if (null != employee.getSalary()) {
			ExistingEmployee.setSalary(employee.getSalary());
		}
		employeeDao.updateEmployee(ExistingEmployee, employeeId);
		return employeeDao.getEmployee(employeeId);
	}

	public void deleteEmployee(int employeeId) {
		employeeDao.deleteEmployee(employeeId);
	}

}
