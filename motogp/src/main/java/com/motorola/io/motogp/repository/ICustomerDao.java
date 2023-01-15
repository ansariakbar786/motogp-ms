package com.motorola.io.motogp.repository;

import java.util.List;

import com.motorola.io.motogp.entities.collection.Customer;
import com.motorola.io.motogp.entities.collection.CustomerVO;

public interface ICustomerDao {
	List<Customer> createListCustomer(List<Customer> customers);

	List<Customer> searchCustomer(CustomerVO customerVO);
}
