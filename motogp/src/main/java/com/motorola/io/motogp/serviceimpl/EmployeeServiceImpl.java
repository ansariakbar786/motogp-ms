package com.motorola.io.motogp.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import com.motorola.io.motogp.dao.IEmployeeRepository;
import com.motorola.io.motogp.entities.Employee;
import com.motorola.io.motogp.service.IEmployeeService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements IEmployeeService {

	@Lazy
	@Autowired
	private IEmployeeRepository employeeRepository;

	@Override
	public Employee addEmployee(Employee e) {
		// TODO Auto-generated method stub
		return employeeRepository.save(e);
	}

	@Override
	public Employee fetch(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Employee deleteEmployee(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Employee> getEmployee() {
		// TODO Auto-generated method stub
		return (List<Employee>) employeeRepository.findAll();
	}

	@Override
	public Employee getEmployeeById(long id) {
		// TODO Auto-generated method stub
		Optional<Employee> op= employeeRepository.findById(id);
		return op.get();
	}

	@Override
	public Employee deleteEmployeeById(long id) {
		// TODO Auto-generated method stub
		Employee e = employeeRepository.findById(id).get();
		if (null != e)
			employeeRepository.deleteById(id);
		return e;
	}

	@Override
	public Employee updateEmployee(Employee updatedEmployee) {
		// TODO Auto-generated method stub
		Employee originalEmployee = employeeRepository.getReferenceById(updatedEmployee.getId());
		mapperForEmployee(updatedEmployee, originalEmployee);
		Employee updateEmployee= employeeRepository.save(originalEmployee);
		return updateEmployee;
	}

	private void mapperForEmployee(Employee updatedEmployee, Employee originalEmployee) {
		// TODO Auto-generated method stub
		if (null != updatedEmployee && null != originalEmployee) {
			if (null != updatedEmployee.getId()) {
				originalEmployee.setId(updatedEmployee.getId());
			}
			if (null != updatedEmployee.getEmail()) {
				originalEmployee.setEmail(updatedEmployee.getEmail());
			}
			if (null != updatedEmployee.getEname()) {
				originalEmployee.setEname(updatedEmployee.getEname());
			}
			if (null != updatedEmployee.getGender()) {
				originalEmployee.setGender(updatedEmployee.getGender());
			}
			if (null != updatedEmployee.getSalary()) {
				originalEmployee.setSalary(updatedEmployee.getSalary());
			}
			/*
			 * if (null != updatedEmployee.isActive()) {
			 * originalEmployee.setSalary(updatedEmployee.getSalary()); }
			 */
		}

	}

}
