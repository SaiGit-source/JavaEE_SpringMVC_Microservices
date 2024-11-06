package com.Springboot.JPARepository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.Springboot.JPARepository.model.Vaccine;
import com.Springboot.JPARepository.service.VaccineService;

@SpringBootApplication
public class JpaRepositoryApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext IOCcontainer = SpringApplication.run(JpaRepositoryApplication.class, args);
		VaccineService vacBean = IOCcontainer.getBean(VaccineService.class);
		System.out.println("searchVaccineById");
		System.out.println(vacBean.searchVaccineById(4));
		// Vaccine [id=4, vaccineName=Flu, manufacturer=AstraZeneca, price=3255.32]
		
		System.out.println("searchVaccineByGivenInfo");
		Vaccine vac = new Vaccine("Pfizer", "Covid", 2334.21);
		vac.setId(6);
		vacBean.searchVaccineByGivenInfo(vac).forEach(v->System.out.println(v));
		
		System.out.println("removeVaccineInfoByIds");
		List<Integer> ids = new ArrayList<>();
		ids.add(2);
		ids.add(4);
		String out = vacBean.removeVaccineInfoByIds(ids);
		System.out.println(out);
		// Unable to delete records
		
	}

}
