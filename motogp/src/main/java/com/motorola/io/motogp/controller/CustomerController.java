package com.motorola.io.motogp.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.motorola.io.motogp.entities.collection.Customer;
import com.motorola.io.motogp.entities.collection.CustomerVO;
import com.motorola.io.motogp.service.ICustomerService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/api/customer")
@Tag(description = "Customer resources that provides access to availabe Employee data", name = "Customer Resource")
public class CustomerController {

	private static final Logger L=LoggerFactory.getLogger(CustomerController.class);
	@Autowired
	ICustomerService customerService;
	
	@PostMapping("/create")
	@Operation(summary = "Create Customer details", description = "Provides all available Customer list")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "OK"),
			@ApiResponse(responseCode = "400", description = "BAD_REQUEST"),
			@ApiResponse(responseCode = "404", description = "NOT_FOUND") })
	public ResponseEntity<Customer> createCustomer(@RequestBody Customer customer){
		L.info("Customer COntroller starts to create Customer Details: ");
		Customer cust=customerService.save(customer);
		L.info("Customer COntroller Ends to create Customer Details: ");
		return new ResponseEntity<Customer>(cust,HttpStatus.CREATED);
	}
	@PostMapping("/create/list")
	@Operation(summary = "Create Customer details", description = "Provides all available Customer list")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "OK"),
			@ApiResponse(responseCode = "400", description = "BAD_REQUEST"),
			@ApiResponse(responseCode = "404", description = "NOT_FOUND") })
	public ResponseEntity<List<Customer>> createListCustomer(@RequestBody List<Customer> customer){
		L.info("Customer COntroller starts to create List of Customer Details: ");
		List<Customer> cust=customerService.createListCustomer(customer);
		L.info("Customer COntroller Ends to create List of Customer Details: ");
		return new ResponseEntity<List<Customer>>(cust,HttpStatus.CREATED);
	}
	@PutMapping("/update/{custId}")
	@Operation(summary = "Create Customer details", description = "Provides all available Customer list")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "OK"),
			@ApiResponse(responseCode = "400", description = "BAD_REQUEST"),
			@ApiResponse(responseCode = "404", description = "NOT_FOUND") })
	public ResponseEntity<Customer> updateCustomer(@PathVariable("custId") String custId,@RequestBody Customer customer){
		L.info("Customer COntroller starts to update Customer Details: ");
		Customer cust=customerService.updateCustomer(custId,customer);
		L.info("Customer COntroller Ends to update Customer Details: ");
		return new ResponseEntity<Customer>(cust,HttpStatus.CREATED);
	}
	@GetMapping("/fetchById/{custId}")
	@Operation(summary = "Create Customer details", description = "Provides all available Customer list")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "OK"),
			@ApiResponse(responseCode = "400", description = "BAD_REQUEST"),
			@ApiResponse(responseCode = "404", description = "NOT_FOUND") })
	public ResponseEntity<Customer> fetchOneCustomer(@PathVariable(value="custId",required = true) String custId){
		L.info("Customer COntroller starts to fetchOneCustomer  Details: ");
		Customer cust=customerService.fetchCustomerById(custId);
		L.info("Customer COntroller Ends to fetchOneCustomer  Details: ");
		return new ResponseEntity<Customer>(cust,HttpStatus.OK);
	}
	@GetMapping("/fetchAllCustomer")
	@Operation(summary = "Create Customer details", description = "Provides all available Customer list")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "OK"),
			@ApiResponse(responseCode = "400", description = "BAD_REQUEST"),
			@ApiResponse(responseCode = "404", description = "NOT_FOUND") })
	public ResponseEntity<List<Customer>> fetchAllCustomer(){
		L.info("Customer COntroller starts to fetchOneCustomer  Details: ");
		List<Customer> cust=customerService.fetchAllCustomer();
		L.info("Customer COntroller Ends to fetchOneCustomer  Details: ");
		return new ResponseEntity<List<Customer>>(cust,HttpStatus.OK);
	}
	
	@DeleteMapping("/deleteById/{custId}")
	@Operation(summary = "Create Customer details", description = "Provides all available Customer list")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "OK"),
			@ApiResponse(responseCode = "400", description = "BAD_REQUEST"),
			@ApiResponse(responseCode = "404", description = "NOT_FOUND") })
	public ResponseEntity<Customer> deleteById(@PathVariable(value="custId", required=true) String custId){
		L.info("Customer COntroller starts to deleteById  Details: ");
		Customer cust=customerService.deleteById(custId);
		L.info("Customer COntroller Ends to deleteById  Details: ");
		return new ResponseEntity<Customer>(cust,HttpStatus.OK);
	}
	
	@DeleteMapping("/deleteAllCustomer")
	@Operation(summary = "Create Customer details", description = "Provides all available Customer list")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "OK"),
			@ApiResponse(responseCode = "400", description = "BAD_REQUEST"),
			@ApiResponse(responseCode = "404", description = "NOT_FOUND") })
	public ResponseEntity<List<Customer>> deleteAllCustomer(){
		L.info("Customer COntroller starts to deleteAllCustomer  Details: ");
		List<Customer> cust=customerService.deleteAllCustomer();
		L.info("Customer COntroller Ends to deleteAllCustomer  Details: ");
		return new ResponseEntity<List<Customer>>(cust,HttpStatus.OK);
	}
	
	@PostMapping("/search/{searchText}")
	@Operation(summary = "Search Customer details", description = "Provides all available Customer list")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "OK"),
			@ApiResponse(responseCode = "400", description = "BAD_REQUEST"),
			@ApiResponse(responseCode = "404", description = "NOT_FOUND") })
	public ResponseEntity<List<Customer>> searchCustomer(@RequestParam(value="searchText",required=false) String searchText,@RequestBody CustomerVO customerVO){
		L.info("Customer COntroller starts to searchCustomer  Details: ");
		List<Customer> customers=null;
		if(null!=searchText) {
			customerVO.setSearchText(searchText);
		}
		customers=customerService.searchCustomer(customerVO);
		L.info("Customer COntroller Ends to searchCustomer  Details: ");
		return new ResponseEntity<List<Customer>>(customers,HttpStatus.OK);
	}
	
}
