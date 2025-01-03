package com.learning.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="newstudentforhql")
public class NewStudent {
	
	@Id
	private Integer sId;
	
	private String sName;
	
	private String sCity;

	public NewStudent() {
		super();
		System.out.println("Zero Param Constructor for Hibernate");
	}

	public Integer getsId() {
		return sId;
	}

	public void setsId(Integer sId) {
		this.sId = sId;
	}

	public String getsName() {
		return sName;
	}

	public void setsName(String sName) {
		this.sName = sName;
	}

	public String getsCity() {
		return sCity;
	}

	public void setsCity(String sCity) {
		this.sCity = sCity;
	}

	@Override
	public String toString() {
		return "NewStudent [sId=" + sId + ", sName=" + sName + ", sCity=" + sCity + "]";
	}
	

}
