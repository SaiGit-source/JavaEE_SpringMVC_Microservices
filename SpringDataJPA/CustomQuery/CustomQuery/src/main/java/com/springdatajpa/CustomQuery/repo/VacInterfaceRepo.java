package com.springdatajpa.CustomQuery.repo;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.springdatajpa.CustomQuery.model.Vaccine;

@Repository
public interface VacInterfaceRepo extends JpaRepository<Vaccine, Integer> {
	
	// HQL query - classnames and fieldnames
	@Query("FROM Vaccine WHERE manufacturer=:company")
	public List<Vaccine> searchByManufacturer(@Param("company")String companyName);
	
	@Query("FROM Vaccine WHERE manufacturer IN(:comp1, :comp2)")
	public List<Vaccine> searchByManufacturer(String comp1,String comp2);
	
	@Query("SELECT vaccineName, manufacturer FROM Vaccine WHERE price BETWEEN :startRange AND :maxRange")
	public List<String> searchVaccinesByPrice(Double startRange, Double maxRange);
	
	
	// @Transactional because these are non-select queries. we want to perform operations in one transactions because we are making changes in database
	@Transactional
	@Modifying
	@Query("UPDATE Vaccine SET price=:newPrice WHERE vaccineName=:vacName")
	public int updatePriceByVaccineName(Double newPrice, @Param("vacName")String vaccineName);
	
	@Transactional
	@Modifying
	@Query("DELETE FROM Vaccine WHERE vaccineName=:vaccineName")
	public int deleteVaccinesByvaccineNames(String vaccineName);
	
	// SQL query
	// tablenames and columnnames not classnames
	
	@Transactional
	@Modifying
	@Query(value="INSERT INTO Vaccine(`id`, `vaccine_name`, `manufacturer`, `price`) VALUES (?,?,?,?)", nativeQuery=true)
	public int insertVaccineRecord(Integer id, String vaccineName, String manufacturer, Double price);

	@Query(value="SELECT NOW() FROM DUAL", nativeQuery=true)
	public Date getRepoSystemDateAndTime();

}
