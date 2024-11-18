package com.Thymeleaf.CRMWebApp.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Customer {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public Integer cid;
	public String cfirstName;
	public String clastName;
	public String ccity;
	public Integer getCid() {
		return cid;
	}
	public void setCid(Integer cid) {
		this.cid = cid;
	}
	public String getCfirstName() {
		return cfirstName;
	}
	public void setCfirstName(String cfirstName) {
		this.cfirstName = cfirstName;
	}
	public String getClastName() {
		return clastName;
	}
	public void setClastName(String clastName) {
		this.clastName = clastName;
	}
	public String getCcity() {
		return ccity;
	}
	public void setCcity(String ccity) {
		this.ccity = ccity;
	}
	public Customer(String cfirstName, String clastName, String ccity) {
		super();
		this.cfirstName = cfirstName;
		this.clastName = clastName;
		this.ccity = ccity;
	}
	public Customer() {
		super();
	}
	@Override
	public String toString() {
		return "Customer [cid=" + cid + ", cfirstName=" + cfirstName + ", clastName=" + clastName + ", ccity=" + ccity
				+ "]";
	}
	

}
