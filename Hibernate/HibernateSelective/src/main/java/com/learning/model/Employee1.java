package com.learning.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Transient;

@Entity // here we are not going to specify @TableName
public class Employee1 {
	
	@Id // primary key
	private Integer eId;
	private String eName; // eName will be the columnName without column annotation
	
	@Transient // we dont want this field part of the table so @Transient
	private String eCity;
	
	private Integer eAge;
	
	
	public Employee1() {
		super();
		System.out.println("Zero param constructor for Hibernate");
	}
	public Integer geteId() {
		return eId;
	}
	public void seteId(Integer eId) {
		this.eId = eId;
	}
	public String geteName() {
		return eName;
	}
	public void seteName(String eName) {
		this.eName = eName;
	}
	public String geteCity() {
		return eCity;
	}

	public void seteCity(String eCity) {
		this.eCity = eCity;
	}
	public Integer geteAge() {
		return eAge;
	}
	public void seteAge(Integer eAge) {
		this.eAge = eAge;
	}
	@Override
	public String toString() {
		return "Employee1 [eId=" + eId + ", eName=" + eName + ", eCity=" + eCity + ", eAge=" + eAge + "]";
	}
	
}
