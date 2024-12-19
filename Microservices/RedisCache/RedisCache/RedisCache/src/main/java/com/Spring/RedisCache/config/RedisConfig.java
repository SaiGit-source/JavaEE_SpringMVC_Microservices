package com.Spring.RedisCache.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;

import com.Spring.RedisCache.model.Country;

@Configuration
public class RedisConfig {

	//Step1: jedisConnectionFactory
	//Jeddis connection factory represents connection with Redis server (to get connection)
	@Bean
	public JedisConnectionFactory jedisConnection()
	{
		JedisConnectionFactory jedis = new JedisConnectionFactory();

		return jedis;
	}
	
	//Step2: redistemplate
	//RedisTemplate -> to perform operations with Redis template
	@Bean
	public RedisTemplate<String, Country> redisTemplate()
	{
		RedisTemplate<String, Country> redisTemplate = new RedisTemplate<>();
		redisTemplate.setConnectionFactory(jedisConnection());
		return redisTemplate;
	}

	
}
