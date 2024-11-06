package com.springdatajpa.CustomFinder;

import java.util.Collection;
import java.util.HashSet;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.springdatajpa.CustomFinder.service.VaccineService;

@SpringBootApplication
public class CustomFinderApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext IOCcontainer = SpringApplication.run(CustomFinderApplication.class, args);
		VaccineService vacBean = IOCcontainer.getBean(VaccineService.class);
		
		/*
		 * 	fetchByPrice
			Vaccine [id=4, vaccineName=Flu, manufacturer=AstraZeneca, price=3255.32]
			Vaccine [id=5, vaccineName=Smallpox, manufacturer=BavarianNordic, price=3255.32]
			
			fetchByPriceLessThanEqual
			Vaccine [id=1, vaccineName=Polio, manufacturer=WHO, price=2393.34]
			Vaccine [id=4, vaccineName=Flu, manufacturer=AstraZeneca, price=3255.32]
			Vaccine [id=5, vaccineName=Smallpox, manufacturer=BavarianNordic, price=3255.32]

			fetchByPriceBetween
			Vaccine [id=4, vaccineName=Flu, manufacturer=AstraZeneca, price=3255.32]
			Vaccine [id=5, vaccineName=Smallpox, manufacturer=BavarianNordic, price=3255.32]

			fetchByVaccineCompanyEquals
			Vaccine [id=2, vaccineName=Covid, manufacturer=Pfizer, price=4393.34]

			fetchByVaccineNameInAndCostBetween
			Vaccine [id=1, vaccineName=Polio, manufacturer=WHO, price=2393.34]
			Vaccine [id=3, vaccineName=Covid, manufacturer=Moderna, price=3353.34]
		 */
		
		System.out.println("fetchByPrice");
		vacBean.fetchByPrice(3255.32).forEach(v->System.out.println(v));
		
		System.out.println("fetchByPriceLessThanEqual");
		vacBean.fetchByPriceLessThanEqual(3353.12).forEach(v->System.out.println(v));
		
		System.out.println("fetchByPriceBetween");
		vacBean.fetchByPriceBetween(2500.12, 3300.12).forEach(v->System.out.println(v));
		
		System.out.println("fetchByVaccineCompanyEquals");
		vacBean.fetchByVaccineCompanyEquals("Pfizer").forEach(v->System.out.println(v));
		
		System.out.println("fetchByVaccineNameInAndCostBetween");		
		Collection<String> vaccineNames=new HashSet<>();
		vaccineNames.add("Polio");
		vaccineNames.add("Covid");		
		vacBean.fetchByVaccineNameInAndCostBetween(vaccineNames, 2200.12, 4300.23).forEach(v->System.out.println(v));
				
	}

}
