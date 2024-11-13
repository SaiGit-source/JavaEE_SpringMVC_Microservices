package com.springmvc.TwoWayBinding.model;

public class Employee {
	// pre-populating for two way binding
	public String eid="T354";
	public String ename = "Abc";
	public String ecity="Charlotte";
	public Double esalary = 2343.45;
	public String getEid() {
		return eid;
	}
	public void setEid(String eid) {
		this.eid = eid;
	}
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	public String getEcity() {
		return ecity;
	}
	public void setEcity(String ecity) {
		this.ecity = ecity;
	}
	public Double getEsalary() {
		return esalary;
	}
	public void setEsalary(Double esalary) {
		this.esalary = esalary;
	}
	public Employee(String eid, String ename, String ecity, Double esalary) {
		super();
		this.eid = eid;
		this.ename = ename;
		this.ecity = ecity;
		this.esalary = esalary;
	}
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Employee [eid=" + eid + ", ename=" + ename + ", ecity=" + ecity + ", esalary=" + esalary + "]";
	}
	
}
