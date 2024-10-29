package com.springboot.SpringJDBC.repo;

import java.util.List;

import com.springboot.SpringJDBC.model.Employee;

public interface EmployeeDaoInterface {
	public List<Employee> getEmployeeInfo();
}
