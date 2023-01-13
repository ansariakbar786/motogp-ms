package com.motorola.io.motogp.entities;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor

public class Employee {
	private static final long serialVersionUID = 4048798961366546485L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@JsonProperty("ename")
	private String ename;
	@JsonProperty("email")
	private String email;
	@JsonProperty("salary")
	private BigDecimal salary;
	@JsonProperty("gender")
	private String gender;
	@JsonProperty("isActive")
	private boolean isActive;

}
