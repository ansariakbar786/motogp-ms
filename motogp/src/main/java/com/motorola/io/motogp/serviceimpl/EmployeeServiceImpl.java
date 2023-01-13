package com.motorola.io.motogp.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.motorola.io.motogp.dao.IEmployeeRepository;
import com.motorola.io.motogp.entities.Employee;
import com.motorola.io.motogp.service.IEmployeeService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
@Component
public class EmployeeServiceImpl implements IEmployeeService{
	
	@Lazy
    @Autowired
	private IEmployeeRepository empRepo;

	@Override
	public Employee addEmployee(Employee e) {
		// TODO Auto-generated method stub
		return empRepo.save(e);
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
		return (List<Employee>) empRepo.findAll();
	}

	@Override
	public Employee getEmployeeById(long id) {
		// TODO Auto-generated method stub
		return empRepo.findById(id).get();
	}

	@Override
	public Employee deleteEmployeeById(long id) {
		// TODO Auto-generated method stub
		Employee e=empRepo.findById(id).get();
		if(null!=e)
		 empRepo.deleteById(null);
		return e;
	}

	@Override
	public Employee updateEmployee(Employee employee) {
		// TODO Auto-generated method stub
		return empRepo.save(employee);
	}

}
