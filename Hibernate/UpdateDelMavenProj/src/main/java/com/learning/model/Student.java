package com.learning.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity // based on classname a table will be created
@Table(name="StudentTable") // here tablename can be specified
public class Student 
{	
	@Id // specify primary key
	@Column(name="SID")
	private Integer sid;
	
	@Column(name="SNAME")
	private String sname;
	
	@Column(name="SCITY")
	private String scity;
	
	public Student() {
		System.out.println("Zero param Constructor for Hibernate");
	}

	public Integer getSid() {
		return sid;
	}

	public void setSid(Integer sid) {
		this.sid = sid;
	}

	public String getSname() {
		return sname;
	}

	public void setSname(String sname) {
		this.sname = sname;
	}

	public String getScity() {
		return scity;
	}

	public void setScity(String scity) {
		this.scity = scity;
	}

}
