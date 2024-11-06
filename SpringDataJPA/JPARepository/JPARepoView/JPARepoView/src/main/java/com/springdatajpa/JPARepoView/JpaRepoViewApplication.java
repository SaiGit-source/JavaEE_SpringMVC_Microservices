package com.springdatajpa.JPARepoView;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.springdatajpa.JPARepoView.service.VaccineService;
import com.springdatajpa.JPARepoView.service.VaccineServiceNew;
import com.springdatajpa.JPARepoView.view.ResultView1;
import com.springdatajpa.JPARepoView.view.ResultView2;

@SpringBootApplication
public class JpaRepoViewApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext IOCcontainer = SpringApplication.run(JpaRepoViewApplication.class, args);
		VaccineServiceNew vacBean = IOCcontainer.getBean(VaccineServiceNew.class);
		vacBean.fetchByCostLessThan(4323.2, ResultView1.class).forEach(v->System.out.println(v.getVaccineName()+" "+v.getManufacturer())); // ResultView1 polymorphism with View interface
		
		/*
		 * 	Polio WHO
			Covid Moderna
			Flu AstraZeneca
			Smallpox BavarianNordic
		 */
		
		vacBean.fetchByCostLessThan(345644.34, ResultView2.class).forEach(v->System.out.println(v.getPrice()+" "+v.getVaccineName()+" "+v.getManufacturer()));	
		
		/*
		 * 	2393.34 Polio WHO
			4393.34 Covid Pfizer
			3353.34 Covid Moderna
			3255.32 Flu AstraZeneca
			3255.32 Smallpox BavarianNordic
		 */
	}

}
