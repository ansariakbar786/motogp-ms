package com.motorola.io.motogp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.motorola.io.motogp.entities.Employee;
import com.motorola.io.motogp.service.IEmployeeService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/")
@Tag(description = "Employee resources that provides access to availabe Employee data", name = "Employee Resource")
public class EmployeeController {

	@Autowired
	IEmployeeService empService;
	
	@GetMapping("/test")
	public String test() {
		return "Application works";
	}

	@PostMapping("/create")
	@Operation(summary = "Create Employee details", description = "Provides all available Employee list")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "OK"),
			@ApiResponse(responseCode = "400", description = "BAD_REQUEST", content = {
					@Content(examples = { @ExampleObject(value = "") }) }),
			@ApiResponse(responseCode = "404", description = "NOT_FOUND", content = {
					@Content(examples = { @ExampleObject(value = "") }) }) })
	public ResponseEntity<Employee> createEmployee(@RequestBody Employee employee) {
		Employee emp = empService.addEmployee(employee);
		return new ResponseEntity<Employee>(emp, HttpStatus.ACCEPTED);

	}
	
	@PutMapping("/update")
	@Operation(summary = "Update Employee details", description = "Provides all available Employee list")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "OK"),
			@ApiResponse(responseCode = "400", description = "BAD_REQUEST", content = {
					@Content(examples = { @ExampleObject(value = "") }) }),
			@ApiResponse(responseCode = "404", description = "NOT_FOUND", content = {
					@Content(examples = { @ExampleObject(value = "") }) }) })
	public ResponseEntity<Employee> updateEmployee(@RequestBody Employee employee) {
		Employee emp = empService.updateEmployee(employee);
		return new ResponseEntity<Employee>(emp, HttpStatus.ACCEPTED);

	}
	
	
	@GetMapping("/fetch")
	@Operation(summary = "Fetch Employee details", description = "Provides all available Employee list")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "OK"),
			@ApiResponse(responseCode = "400", description = "BAD_REQUEST", content = {
					@Content(examples = { @ExampleObject(value = "") }) }),
			@ApiResponse(responseCode = "404", description = "NOT_FOUND", content = {
					@Content(examples = { @ExampleObject(value = "") }) }) })
	public ResponseEntity<List<Employee>> fetchEmployee() {
		List<Employee> emp = empService.getEmployee();
		return new ResponseEntity<List<Employee>>(emp, HttpStatus.FOUND);

	}
	
	
	@GetMapping("/fetchById")
	@Operation(summary = "Fetch Employee details by Id", description = "Provides all available Employee list")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "OK"),
			@ApiResponse(responseCode = "400", description = "BAD_REQUEST", content = {
					@Content(examples = { @ExampleObject(value = "") }) }),
			@ApiResponse(responseCode = "404", description = "NOT_FOUND", content = {
					@Content(examples = { @ExampleObject(value = "") }) }) })
	public ResponseEntity<Employee> fetchEmployeeById(@RequestParam("id") long id) {
		Employee emp = empService.getEmployeeById(id);
		return new ResponseEntity<Employee>(emp, HttpStatus.FOUND);

	}
	
	@DeleteMapping("/deleteById")
	@Operation(summary = "Fetch Employee details by Id", description = "Provides all available Employee list")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "OK"),
			@ApiResponse(responseCode = "400", description = "BAD_REQUEST", content = {
					@Content(examples = { @ExampleObject(value = "") }) }),
			@ApiResponse(responseCode = "404", description = "NOT_FOUND", content = {
					@Content(examples = { @ExampleObject(value = "") }) }) })
	public ResponseEntity<Employee> deleteEmployeeById(@RequestParam("id") long id) {
		Employee emp = empService.deleteEmployeeById(id);
		return new ResponseEntity<Employee>(emp, HttpStatus.FOUND);

	}
	
	@GetMapping("/cache/clear")
	@Operation(summary = "Clear the Browser cache", description = "to clear the browser cache")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "OK"),
			@ApiResponse(responseCode = "400", description = "BAD_REQUEST", content = {
					@Content(examples = { @ExampleObject(value = "") }) }),
			@ApiResponse(responseCode = "404", description = "NOT_FOUND", content = {
					@Content(examples = { @ExampleObject(value = "") }) }) })
	public ResponseEntity<HttpServletResponse> clearCache(HttpServletResponse httpResponse) {
		httpResponse.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1.
		httpResponse.setHeader("Pragma", "no-cache"); // HTTP 1.0.
		httpResponse.setDateHeader("Expires", 0); // Proxies.
		return new ResponseEntity<HttpServletResponse>(httpResponse, HttpStatus.OK);

	}


}
