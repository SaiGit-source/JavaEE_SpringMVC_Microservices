package com.Courses.HateosEx.model;

import org.springframework.hateoas.RepresentationModel;

public class Courses extends RepresentationModel {
	private Integer cId;
	
	private String cName;
	
	private Double cCost;

	public Integer getcId() {
		return cId;
	}

	public void setcId(Integer cId) {
		this.cId = cId;
	}

	public String getcName() {
		return cName;
	}

	public void setcName(String cName) {
		this.cName = cName;
	}

	public Double getcCost() {
		return cCost;
	}

	public void setcCost(Double cCost) {
		this.cCost = cCost;
	}

	public Courses(Integer cId, String cName, Double cCost) {
		super();
		this.cId = cId;
		this.cName = cName;
		this.cCost = cCost;
	}

	@Override
	public String toString() {
		return "Courses [cId=" + cId + ", cName=" + cName + ", cCost=" + cCost + "]";
	}
	
}
