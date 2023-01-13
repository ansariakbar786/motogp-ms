package com.motorola.io.motogp.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.motorola.io.motogp.entities.Employee;


public interface IEmployeeRepository extends CrudRepository<Employee, Long> {

}
