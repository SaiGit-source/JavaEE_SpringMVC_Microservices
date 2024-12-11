package com.SpringSecurity.OAuthApp.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

// we got to disrupt the default Spring Security config for that we got to create a @Bean

@Configuration
@EnableWebSecurity
public class SecurityConfig {
	
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception
	{
		http.authorizeHttpRequests(auth->auth.anyRequest().authenticated())
		.oauth2Login(Customizer.withDefaults()); // thats where we say OAuth2
		return http.build();
	}


}
