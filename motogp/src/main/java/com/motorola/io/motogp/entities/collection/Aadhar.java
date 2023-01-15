package com.motorola.io.motogp.entities.collection;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


public class Aadhar {
	@JsonProperty("aadharId")
	private String aadharId;
	@JsonProperty("name")
	private String name;
	public String getAadharId() {
		return aadharId;
	}
	public void setAadharId(String aadharId) {
		this.aadharId = aadharId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	

}
