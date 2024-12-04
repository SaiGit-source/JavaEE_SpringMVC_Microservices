package com.SpringBatch.BatchProcessing.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "CustomerBatch")
public class Customer {

	@Id
	public Integer CustomerID;
	public String FirstName;
	public String LastName;
	public String Email;
	public String PhoneNumber;
	public String Address;
	public String City;
	public String State;
	public String ZipCode;
	public String Country;
	public Integer getCustomerID() {
		return CustomerID;
	}
	public void setCustomerID(Integer customerID) {
		CustomerID = customerID;
	}
	public String getFirstName() {
		return FirstName;
	}
	public void setFirstName(String firstName) {
		FirstName = firstName;
	}
	public String getLastName() {
		return LastName;
	}
	public void setLastName(String lastName) {
		LastName = lastName;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public String getPhoneNumber() {
		return PhoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		PhoneNumber = phoneNumber;
	}
	public String getAddress() {
		return Address;
	}
	public void setAddress(String address) {
		Address = address;
	}
	public String getCity() {
		return City;
	}
	public void setCity(String city) {
		City = city;
	}
	public String getState() {
		return State;
	}
	public void setState(String state) {
		State = state;
	}
	public String getZipCode() {
		return ZipCode;
	}
	public void setZipCode(String zipCode) {
		ZipCode = zipCode;
	}
	public String getCountry() {
		return Country;
	}
	public void setCountry(String country) {
		Country = country;
	}
	public Customer(Integer customerID, String firstName, String lastName, String email, String phoneNumber,
			String address, String city, String state, String zipCode, String country) {
		super();
		CustomerID = customerID;
		FirstName = firstName;
		LastName = lastName;
		Email = email;
		PhoneNumber = phoneNumber;
		Address = address;
		City = city;
		State = state;
		ZipCode = zipCode;
		Country = country;
	}
	public Customer() {
		super();
	}
	@Override
	public String toString() {
		return "Customer [CustomerID=" + CustomerID + ", FirstName=" + FirstName + ", LastName=" + LastName + ", Email="
				+ Email + ", PhoneNumber=" + PhoneNumber + ", Address=" + Address + ", City=" + City + ", State="
				+ State + ", ZipCode=" + ZipCode + ", Country=" + Country + "]";
	}
	
	
}
