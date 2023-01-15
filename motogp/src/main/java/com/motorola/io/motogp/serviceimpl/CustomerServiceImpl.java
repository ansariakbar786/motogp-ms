package com.motorola.io.motogp.serviceimpl;

import java.util.List;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import com.motorola.io.motogp.entities.collection.Aadhar;
import com.motorola.io.motogp.entities.collection.Address;
import com.motorola.io.motogp.entities.collection.Customer;
import com.motorola.io.motogp.entities.collection.CustomerVO;
import com.motorola.io.motogp.repository.ICustomerDao;
import com.motorola.io.motogp.repository.ICustomerRepository;
import com.motorola.io.motogp.service.ICustomerService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class CustomerServiceImpl implements ICustomerService {
	private static final Logger L=LoggerFactory.getLogger(CustomerServiceImpl.class);
	@Lazy
	@Autowired
	ICustomerRepository customerRepository;
	
	@Lazy
	@Autowired
	ICustomerDao customerDao;

	@Override
	public Customer save(Customer customer) {
		// TODO Auto-generated method stub
		L.info("CustomerServiceImpl starts from here to save the data: ");
		customer.setCustId(UUID.randomUUID().toString());
		return customerRepository.save(customer);
	}

	@Override
	public Customer updateCustomer(String custId, Customer updatedCustomer) {
		// TODO Auto-generated method stub
		Customer actualCustomer=customerRepository.findByCustId(custId);
		mapperForCustomer(updatedCustomer,actualCustomer);
		customerRepository.save(actualCustomer);
		return actualCustomer;
	}

	private void mapperForCustomer(Customer updatedCustomer, Customer actualCustomer) {
		// TODO Auto-generated method stub
		if(null!=actualCustomer && null!=updatedCustomer) {
			if(null!=updatedCustomer.getCustId()) {
				actualCustomer.setCustId(updatedCustomer.getCustId());
			}
			if(null!=updatedCustomer.getFirstName()) {
				actualCustomer.setFirstName(updatedCustomer.getFirstName());
			}
			if(null!=updatedCustomer.getLastName()) {
				actualCustomer.setLastName(updatedCustomer.getLastName());
			}
			if(null!=updatedCustomer.getAge()) {
				actualCustomer.setAge(updatedCustomer.getAge());
			}
			if(null!=updatedCustomer.getSalary()) {
				actualCustomer.setSalary(updatedCustomer.getSalary());
			}
			if(null!=updatedCustomer.getHobbies()) {
				updatedCustomer.getHobbies().forEach(hobby->{
					if(null!=hobby) {
						actualCustomer.getHobbies().add(hobby);
					}
				});
			}
			if(null!=updatedCustomer.getAadhars()) {
				updatedCustomer.getAadhars().forEach(a->{
					Aadhar ad=new Aadhar();
					if(null!=a.getAadharId()) {
						ad.setAadharId(a.getAadharId());
					}
					if(null!=a.getName()) {
						ad.setName(a.getName());
					}
					actualCustomer.getAadhars().add(ad);
				});
			}
			if(null!=updatedCustomer.getAddresses()) {
				updatedCustomer.getAddresses().forEach(address->{
					Address addr=new Address();
					if(null!=address.getAddress1()) {
						addr.setAddress1(address.getAddress1());
					}
					if(null!=address.getAddress2()) {
						addr.setAddress2(address.getAddress2());
					}
					if(null!=address.getCity()) {
						addr.setCity(address.getCity());
					}
					if(null!=address.getState()) {
						addr.setState(address.getState());
					}
					if(null!=address.getCountry()) {
						addr.setCountry(address.getCountry());
					}
					if(null!=address.getPinCode()) {
						addr.setPinCode(address.getPinCode());
					}
					actualCustomer.getAddresses().add(addr);
				});
			}
			
		}
		
	}

	@Override
	public Customer fetchCustomerById(String custId) {
		// TODO Auto-generated method stub
		Customer customer= customerRepository.findByCustId(custId);
		 return customer;
	}

	@Override
	public List<Customer> fetchAllCustomer() {
		// TODO Auto-generated method stub
		return customerRepository.findAll();
	}

	@Override
	public Customer deleteById(String custId) {
		// TODO Auto-generated method stub
		Customer c=customerRepository.findByCustId(custId);
		if(null!=c)
			customerRepository.deleteByCustId(custId);
		return c;
	}

	@Override
	public List<Customer> deleteAllCustomer() {
		// TODO Auto-generated method stub
		List<Customer> customList=customerRepository.findAll();
		if(null!=customList)
			customerRepository.deleteAll();
		return customList;
	}

	@Override
	public List<Customer> createListCustomer(List<Customer> customer) {
		// TODO Auto-generated method stub
		return customerDao.createListCustomer(customer);
	}

	@Override
	public List<Customer> searchCustomer(CustomerVO customerVO) {
		// TODO Auto-generated method stub
		return customerDao.searchCustomer(customerVO);
	}

	
}
