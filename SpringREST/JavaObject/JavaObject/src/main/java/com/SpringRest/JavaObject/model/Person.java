package com.SpringRest.JavaObject.model;

public class Person {
	public Integer pid;
	public String pname;
	public String pcity;
	public Integer getPid() {
		return pid;
	}
	public void setPid(Integer pid) {
		this.pid = pid;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public String getPcity() {
		return pcity;
	}
	public void setPcity(String pcity) {
		this.pcity = pcity;
	}
	public Person(Integer pid, String pname, String pcity) {
		super();
		this.pid = pid;
		this.pname = pname;
		this.pcity = pcity;
	}
	public Person() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Person [pid=" + pid + ", pname=" + pname + ", pcity=" + pcity + "]";
	}
	
}
