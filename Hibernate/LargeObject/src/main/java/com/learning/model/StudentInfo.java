package com.learning.model;

import java.util.Arrays;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;

@Entity
@Table(name="StudentLOBEx")
public class StudentInfo {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY) // automatic ID generation
	private Integer sid;
	
	private String sName;
	
	private String sCity;
	
	//  column to store large images BLOB
	@Lob
	@Column(length=1000000) // just to be safe we are setting a large length
	private byte[] image;
	
	// CLOB
	@Lob
	@Column(length=10000)
	private char[] textFile;

	public StudentInfo() {
		super();
		System.out.println("Zero Param Constructor for Hibernate");
	}
	
	
	public byte[] getImage() {
		return image;
	}


	public void setImage(byte[] image) {
		this.image = image;
	}


	public char[] getTextFile() {
		return textFile;
	}



	public void setTextFile(char[] textFile) {
		this.textFile = textFile;
	}



	public Integer getSid() {
		return sid;
	}

	public void setSid(Integer sid) {
		this.sid = sid;
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
		return "StudentInfo [sid=" + sid + ", sName=" + sName + ", sCity=" + sCity + ", image=" + Arrays.toString(image)
				+ ", textFile=" + Arrays.toString(textFile) + "]";
	}

	
}
