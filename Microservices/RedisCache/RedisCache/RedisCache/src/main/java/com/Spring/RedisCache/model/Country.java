package com.Spring.RedisCache.model;

import java.io.Serializable;

public class Country implements Serializable {
	
	private Integer num;
	private String name;	
	private String countryCode;
	public Integer getNum() {
		return num;
	}
	public void setNum(Integer num) {
		this.num = num;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCountryCode() {
		return countryCode;
	}
	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}
	public Country(Integer num, String name, String countryCode) {
		super();
		this.num = num;
		this.name = name;
		this.countryCode = countryCode;
	}
	public Country() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Country [num=" + num + ", name=" + name + ", countryCode=" + countryCode + "]";
	}

}
