package com.springdatajpa.MongoDBExample.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document // @Document instead of @Entity in MongoDB
public class Customer {
	
	//@Id
	private String id;
	private Integer custNo;
	private String name;
	private String city;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Integer getCustNo() {
		return custNo;
	}
	public void setCustNo(Integer custNo) {
		this.custNo = custNo;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public Customer(Integer custNo, String name, String city) {
		super();
		//this.id = id;
		this.custNo = custNo;
		this.name = name;
		this.city = city;
	}
	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public String toString() {
		return "Customer [id=" + id + ", custNo=" + custNo + ", name=" + name + ", city=" + city + "]";
	}
	

}
