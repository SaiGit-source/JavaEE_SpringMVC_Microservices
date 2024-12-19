package com.Spring.RedisCache.service;

import java.util.Collection;
import java.util.Map;

import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import com.Spring.RedisCache.model.Country;

@Service
public class CountryService {

	
	private HashOperations<String, Object, Object> opsForHash=null;
	private ValueOperations<String, Country> opsForValue=null;
	
	// constructor based dependency injection so @Autowired is not required
	public CountryService(RedisTemplate<String, Country> redis)
	{
		opsForHash=redis.opsForHash();
		opsForValue = redis.opsForValue();
	}
	
	public String addCountry(Country country)
	{
		opsForHash.put("COUNTRIES", country.getNum(), country);
		return "Country data added into redis server";
	}
	
	public Collection<Object> getAllCountries()
	{
		
		Map<Object, Object> entries = opsForHash.entries("COUNTRIES");
		Collection<Object> countries=entries.values();
		return countries;
		
	}

}
