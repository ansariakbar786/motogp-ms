package com.motorola.io.motogp.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.motorola.io.motogp.entities.Employee;

@Repository
public interface IEmployeeRepository extends JpaRepository<Employee, Long> {

}
