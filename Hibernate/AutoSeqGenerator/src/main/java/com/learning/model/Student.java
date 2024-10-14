package com.learning.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity // based on classname a table will be created
@Table(name="StudentTableAutoGenerate") // here tablename can be specified
public class Student 
{	
	@Id // specify primary key
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="mySqequence") // to generate IDs automatically. specify .SEQUENCE for Oracle DB, .AUTO when DB vendor is unknown, .IDENTITY for MySQL
	@SequenceGenerator(name="mySqequence", sequenceName="My_seq", initialValue=100, allocationSize=1) // our own sequence, allocationSize=1 increment by 1
	// initialvalue starts from 100
	// @Column(name="SID")
	private Integer sid;
	
	//@Column(name="SNAME")
	private String sname;
	
	//@Column(name="SCITY")
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

	@Override
	public String toString() {
		return "Student [sid=" + sid + ", sname=" + sname + ", scity=" + scity + "]";
	}
	
}
