package com.motorola.io.motogp.entities.collection;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;


@Document(collection = "customer")
public class Customer implements Serializable {
	private static final long serialVersionUID = 4048798961366546489L;
	@JsonSerialize(using=ToStringSerializer.class)
	private String custId;
	@JsonProperty("firstName")
	private String firstName;
	@JsonProperty("lastName")
	private String lastName;
	@JsonProperty("age")
	private Integer age;
	@JsonProperty("salary")
	private BigDecimal salary;
	@JsonProperty("hobbies")
	private List<String> hobbies;
	@JsonProperty("addresses")
	private List<Address> addresses;
	@JsonProperty("aadhars")
	private List<Aadhar> aadhars;
	public String getCustId() {
		return custId;
	}
	public void setCustId(String custId) {
		this.custId = custId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public BigDecimal getSalary() {
		return salary;
	}
	public void setSalary(BigDecimal salary) {
		this.salary = salary;
	}
	public List<String> getHobbies() {
		return hobbies;
	}
	public void setHobbies(List<String> hobbies) {
		this.hobbies = hobbies;
	}
	public List<Address> getAddresses() {
		return addresses;
	}
	public void setAddresses(List<Address> addresses) {
		this.addresses = addresses;
	}
	public List<Aadhar> getAadhars() {
		return aadhars;
	}
	public void setAadhars(List<Aadhar> aadhars) {
		this.aadhars = aadhars;
	}
	
	
	
	

}
