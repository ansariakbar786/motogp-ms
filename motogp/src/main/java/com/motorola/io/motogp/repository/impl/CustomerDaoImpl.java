package com.motorola.io.motogp.repository.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.data.mongodb.core.BulkOperations;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

import com.motorola.io.motogp.entities.collection.Aadhar;
import com.motorola.io.motogp.entities.collection.Address;
import com.motorola.io.motogp.entities.collection.Customer;
import com.motorola.io.motogp.entities.collection.CustomerVO;
import com.motorola.io.motogp.repository.ICustomerDao;
import com.motorola.io.motogp.repository.ICustomerRepository;

import io.micrometer.common.util.StringUtils;

@Repository
public class CustomerDaoImpl implements ICustomerDao{
	private static final Logger L=LoggerFactory.getLogger(CustomerDaoImpl.class);
	
	@Autowired
	MongoTemplate mongoTemplate;
	
	@Lazy
	@Autowired
	ICustomerRepository customerRepository;
	
	


	@Override
	public List<Customer> createListCustomer(List<Customer> customers) {
		BulkOperations bulkOperations = mongoTemplate.bulkOps(BulkOperations.BulkMode.UNORDERED, "customer");
		//List<Pair<Query, Update>> updates = new ArrayList<>(customers.size());
		/*
		 * customers.forEach(customer -> { if(StringUtils.isEmpty(customer.getCustId()))
		 * { customer.setCustId(UUID.randomUUID().toString());
		 * 
		 * } Query query = Query.query(Criteria.where("_id").is(customer.getCustId()));
		 * Update update = new Update(); mapperUpdateForCustomer(update,customer); //
		 * updates.add(Pair.of(query, update)); bulkOperations.upsert(query, update) });
		 * 
		 * BulkWriteResult bulkWriteResult=bulkOperations.execute();
		 */
		int insertCount=0;
		int updateCount=0;
		for(Customer customer: customers){
			
			if(StringUtils.isEmpty(customer.getCustId())) {
				insertCount++;
				customer.setCustId(UUID.randomUUID().toString());
				customerRepository.save(customer);
			}else {
				updateCount++;
				Customer actualCustomer=customerRepository.findByCustId(customer.getCustId());
				mapperForCustomer(customer,actualCustomer);
				customerRepository.save(actualCustomer);
				//return null;
			}
		}
		//L.info("Saved count data in mongodb: "+bulkWriteResult.getInsertedCount()+" Update count: "+bulkWriteResult.getModifiedCount());
		L.info("Saved count data in mongodb: "+insertCount+" Update count: "+updateCount);
		return null;
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
				List<String> hobbies=new ArrayList<>();
				updatedCustomer.getHobbies().forEach(hobby->{
					if(null!=hobby) {
						hobbies.add(hobby);
					}
				});
				actualCustomer.setHobbies(hobbies);
			}
			if(null!=updatedCustomer.getAadhars()) {
				List<Aadhar> aadhars=new ArrayList<>();
				updatedCustomer.getAadhars().forEach(a->{
					Aadhar ad=new Aadhar();
					updatedCustomer.getAadhars().forEach(origAdhar->{
					
					if(null==a.getAadharId() && !a.getAadharId().equals(origAdhar.getAadharId())) {
						ad.setAadharId(a.getAadharId());
					}
					if(null!=a.getName() && !a.getName().equals(origAdhar.getName())) {
						ad.setName(a.getName());
					}
					aadhars.add(ad);
					});
				});
				actualCustomer.setAadhars(aadhars);
			}
			if(null!=updatedCustomer.getAddresses()) {
				List<Address> addresses=new ArrayList<>();
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
					addresses.add(addr);
					
				});
				actualCustomer.setAddresses(addresses);
			}
			
		}
		
	}
	
	
	private void mapperUpdateForCustomer(Update update, Customer customer) {

		if (null != customer) {
			if (null != customer.getCustId()) {
				update.set("custId", customer.getCustId());
			}
			if (null != customer.getFirstName()) {
				update.set("firstName", customer.getFirstName());
			}
			if (null != customer.getLastName()) {
				update.set("lastName", customer.getLastName());
			}
			if (null != customer.getAge()) {
				update.set("age", customer.getAge());
			}
			if (null != customer.getSalary()) {
				update.set("salary", customer.getSalary());
			}
			if (null != customer.getHobbies()) {
				List<String> hobbies=new ArrayList<>();
				customer.getHobbies().stream().forEach(h -> {
					if (null != h) {
						hobbies.add(h);
					}
				});
				update.set("hobbies", hobbies);
			}
			if (null != customer.getAadhars()) {
				List<Aadhar> aadhars=new ArrayList<>();
				customer.getAadhars().forEach(a -> {
					Aadhar ad = new Aadhar();
					if (null != a.getAadharId()) {
						ad.setAadharId(a.getAadharId());
					}
					if (null != a.getName()) {
						ad.setName(a.getName());
					}
					aadhars.add(ad);
				});

				update.set("aadhars", aadhars);
			}
			if (null != customer.getAddresses()) {
				List<Address> addresses=new ArrayList<>();
				customer.getAddresses().forEach(address -> {
					Address addr = new Address();
					if (null != address.getAddress1()) {
						addr.setAddress1(address.getAddress1());
					}
					if (null != address.getAddress2()) {
						addr.setAddress2(address.getAddress2());
					}
					if (null != address.getCity()) {
						addr.setCity(address.getCity());
					}
					if (null != address.getState()) {
						addr.setState(address.getState());
					}
					if (null != address.getCountry()) {
						addr.setCountry(address.getCountry());
					}
					if (null != address.getPinCode()) {
						addr.setPinCode(address.getPinCode());
					}
					addresses.add(addr);
				});
				update.set("addresses", addresses);
			}
		}
	}

	@Override
	public List<Customer> searchCustomer(CustomerVO customerVO) {
		// TODO Auto-generated method stub
		Criteria criteria=new Criteria();
		if(!StringUtils.isEmpty(customerVO.getSearchText())) {
			Criteria c1=new Criteria("aadhars.aadharId");
			c1.regex(".*"+customerVO.getSearchText()+"*", "i");
			
			Criteria c2=new Criteria("addresses .address1");
			c2.regex(".*"+customerVO.getSearchText()+"*", "i");
			
			Criteria c3=new Criteria("addresses.city");
			c3.regex(".*"+customerVO.getSearchText()+"*", "i");
			
			Criteria c4=new Criteria("addresses.state");
			c4.regex(".*"+customerVO.getSearchText()+"*", "i");
			
			criteria.orOperator(c1,c2,c3,c4);
		}else {
			if(!StringUtils.isEmpty(customerVO.getCustId())) {
				criteria=criteria.and("custId").is(customerVO.getCustId());
			}
			if(!StringUtils.isEmpty(customerVO.getAadharId())) {
				criteria=criteria.and("aadhars.aadharId").is(customerVO.getAadharId());
			}
			if(!StringUtils.isEmpty(customerVO.getAddress1())) {
				criteria=criteria.and("addresses .address1").is(customerVO.getAddress1());
			}
			if(!StringUtils.isEmpty(customerVO.getCity())) {
				criteria=criteria.and("addresses.city").is(customerVO.getCity());
			}
			if(!StringUtils.isEmpty(customerVO.getState())) {
				criteria=criteria.and("addresses.state").is(customerVO.getState());
			}
			
			
		}
		Query query=new Query(criteria);
		List<Customer> customers=mongoTemplate.find(query, Customer.class);
		return customers;
	}


}
