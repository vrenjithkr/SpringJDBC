package com.renji.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.renji.model.Employee;
import com.renji.service.EmployeeService;

@RestController
@RequestMapping("/api/v1/employee")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	@GetMapping
	public ResponseEntity<List<Employee>> getAllEmployee() {
		List<Employee> employees = employeeService.getAllemployees();
		return new ResponseEntity<>(employees, HttpStatus.OK);
	}

	@GetMapping({ "/{employeeId}" })
	public ResponseEntity<Employee> getEmployee(@PathVariable int employeeId) {
		Employee employee=employeeService.getemployee(employeeId);
		return new ResponseEntity<>(employee, HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<Employee> saveEmployee(@RequestBody Employee employee) {
		Employee newEmployee=employeeService.saveEmployee(employee);
		return new ResponseEntity<>(newEmployee, HttpStatus.CREATED);
	}

	@PutMapping({ "/{employeeId}" })
	public ResponseEntity<Employee> updateEmployee(@PathVariable("employeeId") int employeeId, @RequestBody Employee employee) {
		Employee newemployee=employeeService.updateEmployee(employeeId,employee);
		return new ResponseEntity<>(newemployee, HttpStatus.OK);
	}

	@DeleteMapping({ "/{employeeId}" })
	public ResponseEntity<String> deleteEmployee(@PathVariable("employeeId") int employeeId) {
		employeeService.deleteEmployee(employeeId);
		return new ResponseEntity<String>("User deleted successfully.",HttpStatus.OK);
	}
}
