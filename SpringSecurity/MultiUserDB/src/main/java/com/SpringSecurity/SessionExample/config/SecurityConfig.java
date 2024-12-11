package com.SpringSecurity.SessionExample.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;


@Configuration
@EnableWebSecurity
public class SecurityConfig {
	
	@Autowired
	private UserDetailsService userDetailsService;
	
	// disable CSRF and making application Stateless
	@Bean
	public SecurityFilterChain securityFiltersChain(HttpSecurity http) throws Exception
	{
		http.csrf(customizer->customizer.disable());
		//http.formLogin(Customizer.withDefaults());
		http.authorizeHttpRequests(authorizeHttp->authorizeHttp
				.requestMatchers("add-newuser").permitAll().anyRequest().authenticated());
		//for /add-newuser API, we are permitting all users because it's like a signup page
		
		http.httpBasic(Customizer.withDefaults());
		http.sessionManagement
		(session->session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));
		return http.build();
	}
	
	@Bean
	public AuthenticationProvider authProvider()
	{
		DaoAuthenticationProvider daoProvider = new DaoAuthenticationProvider();
		daoProvider.setUserDetailsService(userDetailsService);
		// daoProvider.setPasswordEncoder(NoOpPasswordEncoder.getInstance()); // this one is No password encoder
		daoProvider.setPasswordEncoder(new BCryptPasswordEncoder(12));
		return daoProvider;
		
	}
	
	// multi-user authentication with NO database
	@Bean
	public UserDetailsService userDetails()
	{
		UserDetails user = User.withDefaultPasswordEncoder()
		.username("user1")
		.password("pwd1")
		.roles("USER")
		.build();
		
		UserDetails admin = User.withDefaultPasswordEncoder()
				.username("admin")
				.password("pwd@123")
				.roles("ADMIN")
				.build();
		
		return new InMemoryUserDetailsManager(user,admin);
	}


}
