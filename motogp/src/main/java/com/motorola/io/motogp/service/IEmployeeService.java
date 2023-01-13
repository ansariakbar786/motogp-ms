package com.motorola.io.motogp.service;

import java.util.List;

import com.motorola.io.motogp.entities.Employee;

public interface IEmployeeService {
	Employee addEmployee(Employee e);
	Employee fetch(Long id);
	Employee deleteEmployee(Long id);
	List<Employee> getEmployee();
	Employee getEmployeeById(long id);
	Employee deleteEmployeeById(long id);
	Employee updateEmployee(Employee employee);

}
