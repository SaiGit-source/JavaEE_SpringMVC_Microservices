package com.springboot.SpringJDBC;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.springboot.SpringJDBC.repo.EmployeeDaoImpl;

/* create table and fill with data in MySQL before running the application
 * 
use finishers;
create table Employees(
id int, 
name varchar(24),
city varchar(24)
);

Insert into Employees(id, name, city) values (1, "Name123", "Tampa");
Insert into Employees(id, name, city) values (2, "Name567", "Fort Lauderdale");
 */


@SpringBootApplication
public class SpringJdbcApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext IOCcontainer = SpringApplication.run(SpringJdbcApplication.class, args);
		EmployeeDaoImpl employees = IOCcontainer.getBean(EmployeeDaoImpl.class);
		employees.getEmployeeInfo().forEach(n->System.out.println(n));	
	}

}
