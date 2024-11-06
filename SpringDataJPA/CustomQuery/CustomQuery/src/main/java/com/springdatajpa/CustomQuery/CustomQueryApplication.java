package com.springdatajpa.CustomQuery;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.springdatajpa.CustomQuery.service.VaccineService;

// In CustomQuery: we have HQL and SQL for HQL we use the classNames, Fieldnames and for SQL we use the TableNames, ColumnNames

// https://docs.spring.io/spring-data/jpa/reference/jpa/query-methods.html

/* Output
 * 	fetchByVaccineCompany
	Vaccine [id=1, vaccineName=Polio, manufacturer=WHO, price=2393.34]
	
	fetchByVaccineCompany
	Vaccine [id=1, vaccineName=Polio, manufacturer=WHO, price=2393.34]
	Vaccine [id=3, vaccineName=Covid, manufacturer=Moderna, price=3353.34]

	fetchVaccinesByCost
	Polio,WHO
	Covid,Moderna
	Flu,AstraZeneca
	Smallpox,BavarianNordic
	Covid,J&J

	updateThePriceByVaccineName
	Record updated successfully
	
	deleteTheVaccinesByvaccineNames
	Record delete failed
	
	insertVaccineDetails
	Record inserted successfully

	getSystemDateAndTime
	2024-11-06 03:01:56.0
 */

@SpringBootApplication
public class CustomQueryApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext container = SpringApplication.run(CustomQueryApplication.class, args);
		VaccineService vacBean = container.getBean(VaccineService.class);
		System.out.println("fetchByVaccineCompany");
		vacBean.fetchByVaccineCompany("WHO").forEach(v->System.out.println(v));
		
		System.out.println("fetchByVaccineCompany");
		vacBean.fetchByVaccineCompany("WHO", "Moderna").forEach(v->System.out.println(v));
		
		System.out.println("fetchVaccinesByCost");
		vacBean.fetchVaccinesByCost(2000.3, 4000.32).forEach(v->System.out.println(v));
		
		System.out.println("updateThePriceByVaccineName");
		int rowAffected = vacBean.updateThePriceByVaccineName(2343.12, "Flu");
		if (rowAffected!=0) {
			System.out.println("Record updated successfully");
		}
		else {
			System.out.println("Record update failed");
		}
		
		System.out.println("deleteTheVaccinesByvaccineNames");
		rowAffected = vacBean.deleteTheVaccinesByvaccineNames("Random");
		if (rowAffected!=0) {
			System.out.println("Record deleted successfully");
		}
		else {
			System.out.println("Record delete failed");
		}
		
		System.out.println("insertVaccineDetails");
		rowAffected=vacBean.insertVaccineDetails(7, "Hepatitis", "GSK", 3426.27);
		if (rowAffected!=0) {
			System.out.println("Record inserted successfully");
		}
		else {
			System.out.println("Record insert failed");
		}
		
		
		System.out.println("getSystemDateAndTime");
		System.out.println(vacBean.getSystemDateAndTime());
	}

}
