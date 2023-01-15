package com.motorola.io.motogp.service;

import java.util.List;

import com.motorola.io.motogp.entities.collection.Customer;
import com.motorola.io.motogp.entities.collection.CustomerVO;

public interface ICustomerService {
	Customer save(Customer customer);

	Customer updateCustomer(String custId, Customer customer);

	Customer fetchCustomerById(String custId);

	List<Customer> fetchAllCustomer();

	Customer deleteById(String custId);

	List<Customer> deleteAllCustomer();

	List<Customer> createListCustomer(List<Customer> customer);

	List<Customer> searchCustomer(CustomerVO customerVO);
	

}
