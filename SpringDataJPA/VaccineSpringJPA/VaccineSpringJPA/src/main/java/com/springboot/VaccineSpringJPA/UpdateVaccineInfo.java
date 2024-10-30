package com.springboot.VaccineSpringJPA;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.springboot.VaccineSpringJPA.service.VaccineService;

// Important set 'spring.jpa.hibernate.ddl-auto=update'

@SpringBootApplication
public class UpdateVaccineInfo {

	public static void main(String[] args) {
		ConfigurableApplicationContext IOCcontainer = SpringApplication.run(VaccineSpringJpaApplication.class, args);
		VaccineService vacBean = IOCcontainer.getBean(VaccineService.class);
		
		// spring.jpa.hibernate.ddl-auto=update
		// Number of vaccines: 5
		System.out.println("Number of vaccines: "+vacBean.getCountVaccines());
		
		Integer id = 4;
		Boolean status = vacBean.checkVacAvailability(id);
		if (status) {			
			System.out.println("Vaccine " + id+ " is available");			
		}
		else {
			System.out.println("Vaccine " + id+ " is NOT available");			
		}
		
		/*
		 * it prints the following
		 * 	Vaccine [id=1, vaccineName=Polio, manufacturer=WHO, price=2393.34]
			Vaccine [id=2, vaccineName=Covid, manufacturer=Pfizer, price=4393.34]
			Vaccine [id=3, vaccineName=Covid, manufacturer=Moderna, price=3353.34]
			Vaccine [id=4, vaccineName=Flu, manufacturer=AstraZeneca, price=3255.32]
			Vaccine [id=5, vaccineName=Smallpox, manufacturer=BavarianNordic, price=3255.32]
		 */
		vacBean.getAllVaccineInfo().forEach(v->System.out.println(v));

	}

}
