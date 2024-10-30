package com.springboot.VaccineSpringJPA;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.springboot.VaccineSpringJPA.model.Vaccine;
import com.springboot.VaccineSpringJPA.service.VaccineService;

//Important set 'spring.jpa.hibernate.ddl-auto=create'
// create all vaccine records in MySQL

@SpringBootApplication
public class VaccineSpringJpaApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext IOCcontainer = SpringApplication.run(VaccineSpringJpaApplication.class, args);
		VaccineService vacBean = IOCcontainer.getBean(VaccineService.class);
		
		// spring.jpa.hibernate.ddl-auto=create
		Vaccine vac1 = new Vaccine("Polio", "WHO", 2393.34);
		Vaccine vac2 = new Vaccine("Covid", "Pfizer", 4393.34);
		Vaccine vac3 = new Vaccine("Covid", "Moderna", 3353.34);
		Vaccine vac4 = new Vaccine("Flu", "AstraZeneca", 3255.32);
		Vaccine vac5 = new Vaccine("Smallpox", "BavarianNordic", 3255.32);
		System.out.println(vacBean.registerVaccineInfo(vac1));
		
		List<Vaccine> listVac = new ArrayList<>();
		listVac.add(vac2);
		listVac.add(vac3);
		listVac.add(vac4);
		listVac.add(vac5);
		vacBean.registerMultipleVaccines(listVac).forEach(v->System.out.println(v)); // we are registering multiple vaccines and we are printing the returned object List
		
		//*******************************************
	}

}
