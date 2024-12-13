package com.SpringBoot.MultiDBProj.model.customer;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Customer {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer cid;
	private String ccity;
	private String cfirst_name;
	private String clast_name;
	public Customer(Integer cid, String ccity, String cfirst_name, String clast_name) {
		super();
		this.cid = cid;
		this.ccity = ccity;
		this.cfirst_name = cfirst_name;
		this.clast_name = clast_name;
	}
	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Integer getCid() {
		return cid;
	}
	public void setCid(Integer cid) {
		this.cid = cid;
	}
	public String getCcity() {
		return ccity;
	}
	public void setCcity(String ccity) {
		this.ccity = ccity;
	}
	public String getCfirst_name() {
		return cfirst_name;
	}
	public void setCfirst_name(String cfirst_name) {
		this.cfirst_name = cfirst_name;
	}
	public String getClast_name() {
		return clast_name;
	}
	public void setClast_name(String clast_name) {
		this.clast_name = clast_name;
	}
	@Override
	public String toString() {
		return "Customer [cid=" + cid + ", ccity=" + ccity + ", cfirst_name=" + cfirst_name + ", clast_name="
				+ clast_name + "]";
	}
	
}
