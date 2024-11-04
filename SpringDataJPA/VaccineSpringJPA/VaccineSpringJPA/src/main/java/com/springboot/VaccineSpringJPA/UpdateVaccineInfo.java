package com.springboot.VaccineSpringJPA;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.springboot.VaccineSpringJPA.model.Vaccine;
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
		
		List<Integer> IDs = new ArrayList<>();
		IDs.add(1);
		IDs.add(3);
		System.out.println("getAllVaccinesByIDs");
		vacBean.getAllVaccinesByIDs(IDs).forEach(v->System.out.println(v));
		/*
		 * 	Vaccine [id=1, vaccineName=Polio, manufacturer=WHO, price=2393.34]
			Vaccine [id=3, vaccineName=Covid, manufacturer=Moderna, price=3353.34]
		 */
		System.out.println(vacBean.removeVaccineById(7));
		// Id: 7 is not present to delete
		
		System.out.println(vacBean.removeAllVaccines(IDs));
		// couldn't delete all IDS
		
		Vaccine obj = new Vaccine("Polio", "NewComp", 3234.34);
		obj.setId(7);
		System.out.println(vacBean.removeVaccineByVaccineObj(obj));
		// Record with id 7 not available to delete
	}

}
