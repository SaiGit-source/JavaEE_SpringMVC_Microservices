package com.springmvc.OneWayBinding.model;

public class Employee {
	public String eid;
	public String ename;
	public String eemail;
	public String ecity="Charlotte"; // it doesn't pre-populate the form because of one-way binding
	public Double esalary;
	
	public String getEid() {
		return eid;
	}
	public Double getEsalary() {
		return esalary;
	}
	public void setEsalary(Double esalary) {
		this.esalary = esalary;
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
	public String getEemail() {
		return eemail;
	}
	public void setEemail(String eemail) {
		this.eemail = eemail;
	}
	public String getEcity() {
		return ecity;
	}
	public void setEcity(String ecity) {
		this.ecity = ecity;
	}
	public Employee(String eid, String ename, String eemail, String ecity, Double esalary) {
		super();
		this.eid = eid;
		this.ename = ename;
		this.eemail = eemail;
		this.ecity = ecity;
		this.esalary = esalary;
	}
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Employee [eid=" + eid + ", ename=" + ename + ", eemail=" + eemail + ", ecity=" + ecity + ", esalary="
				+ esalary + "]";
	}
	
	
}
