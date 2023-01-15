package com.motorola.io.motogp.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.motorola.io.motogp.entities.collection.Customer;

@Repository
public interface ICustomerRepository extends MongoRepository<Customer, String> {
	
	Customer findByCustId(String custId);
	Customer deleteByCustId(String custId);

}
