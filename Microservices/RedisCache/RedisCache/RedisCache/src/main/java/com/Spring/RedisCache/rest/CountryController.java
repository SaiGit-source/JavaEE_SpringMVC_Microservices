package com.Spring.RedisCache.rest;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.Spring.RedisCache.model.Country;
import com.Spring.RedisCache.service.CountryService;

/*
 * RedisCache -> Temporary storage

	-> Data represented in the form of key-value pair
	-> To reduce number of DBcalls from one App

 */
// Start Redis server -> click redis-server.exe installed
// installer is on Git as well
// POST: http://localhost:8080/add-country
/*
 * {
    "num":1,
    "name":"Abc",
    "countryCode": "91"
}
 */

// Country data added into redis server

// GET: http://localhost:8080/get-country
// Note there is no database configured here
// it comes from Redis server
/*
 *     {
        "num": 2,
        "name": "Xyz",
        "countryCode": "+1"
    }
*/

@RestController
public class CountryController {
	
	@Autowired
	private CountryService service;
	
	@PostMapping("/add-country")
	public String addCountry(@RequestBody Country country)
	{
		return service.addCountry(country);
	}
	
	@GetMapping("/get-country")
	public Collection<Object> getCountry()
	{
		return service.getAllCountries();
	}


}
