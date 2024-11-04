package com.springdatajpa.PagingAndSortingRepo;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.springdatajpa.PagingAndSortingRepo.model.Vaccine;
import com.springdatajpa.PagingAndSortingRepo.service.VaccineService;

/* Original list
 *	Vaccine [id=1, vaccineName=Polio, manufacturer=WHO, price=2393.34]
	Vaccine [id=2, vaccineName=Covid, manufacturer=Pfizer, price=4393.34]
	Vaccine [id=3, vaccineName=Covid, manufacturer=Moderna, price=3353.34]
	Vaccine [id=4, vaccineName=Flu, manufacturer=AstraZeneca, price=3255.32]
	Vaccine [id=5, vaccineName=Smallpox, manufacturer=BavarianNordic, price=3255.32]
 */

@SpringBootApplication
public class PagingAndSortingRepoApplication {

	public static void main(String[] args) 
	{
		ConfigurableApplicationContext IOCcontainer = SpringApplication.run(PagingAndSortingRepoApplication.class, args);
		VaccineService vacBean = IOCcontainer.getBean(VaccineService.class);
		List<Vaccine> listVac = (List<Vaccine>) vacBean.fetchDetailsBySorting(true, "manufacturer"); // sort by manufacturer name in ASC order
		listVac.forEach(v->System.out.println(v));
		/* Sorted by manufacturer which is different from the original list output
		 * 	Vaccine [id=4, vaccineName=Flu, manufacturer=AstraZeneca, price=3255.32]
			Vaccine [id=5, vaccineName=Smallpox, manufacturer=BavarianNordic, price=3255.32]
			Vaccine [id=3, vaccineName=Covid, manufacturer=Moderna, price=3353.34]
			Vaccine [id=2, vaccineName=Covid, manufacturer=Pfizer, price=4393.34]
			Vaccine [id=1, vaccineName=Polio, manufacturer=WHO, price=2393.34]
			Vaccine [id=3, vaccineName=Covid, manufacturer=Moderna, price=3353.34]
			Vaccine [id=2, vaccineName=Covid, manufacturer=Pfizer, price=4393.34]
		 */
		
		int numRecords = vacBean.countRecords(listVac);
		
		vacBean.fetchDetailsByPagination(1, 2, true, "manufacturer").forEach(v->System.out.println(v));
		// page is 1 and pagesize is 2
		/*
		 * 	Vaccine [id=3, vaccineName=Covid, manufacturer=Moderna, price=3353.34]
			Vaccine [id=2, vaccineName=Covid, manufacturer=Pfizer, price=4393.34]
		 */
				
		vacBean.fetchDetailsByPagination(numRecords, 2); // pagesize is 2
		
		/*
		 * 
		 * 	-------------Page#: 0
			Polio WHO
			Covid Pfizer
			----------------------------------------
			-------------Page#: 1
			Covid Moderna
			Flu AstraZeneca
			----------------------------------------
			-------------Page#: 2
			Smallpox BavarianNordic
			----------------------------------------
		 */

		
	}

}
