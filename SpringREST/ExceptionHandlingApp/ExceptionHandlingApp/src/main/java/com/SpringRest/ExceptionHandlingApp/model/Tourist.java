package com.SpringRest.ExceptionHandlingApp.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Tourist {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public Integer tid;
	public String tname;
	public String tcity;
	public String packageType;
	public Double budget;
	public Integer getTid() {
		return tid;
	}
	public void setTid(Integer tid) {
		this.tid = tid;
	}
	public String getTname() {
		return tname;
	}
	public void setTname(String tname) {
		this.tname = tname;
	}
	public String getTcity() {
		return tcity;
	}
	public void setTcity(String tcity) {
		this.tcity = tcity;
	}
	public String getPackageType() {
		return packageType;
	}
	public void setPackageType(String packageType) {
		this.packageType = packageType;
	}
	public Double getBudget() {
		return budget;
	}
	public void setBudget(Double budget) {
		this.budget = budget;
	}
	public Tourist(Integer tid, String tname, String tcity, String packageType, Double budget) {
		super();
		this.tid = tid;
		this.tname = tname;
		this.tcity = tcity;
		this.packageType = packageType;
		this.budget = budget;
	}
	public Tourist() {
		super();
	}
	@Override
	public String toString() {
		return "Tourist [tid=" + tid + ", tname=" + tname + ", tcity=" + tcity + ", packageType=" + packageType
				+ ", budget=" + budget + "]";
	} 	
	
}
