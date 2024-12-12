package com.SpringSecurity.SessionExample.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
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
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;


@Configuration
@EnableWebSecurity
public class SecurityConfig {
	
	@Autowired
	private UserDetailsService userDetailsService;
	
	@Autowired
	private JwtFilter jwtFilter;
	
	// disable CSRF and making application Stateless
	@Bean
	public SecurityFilterChain securityFiltersChain(HttpSecurity http) throws Exception
	{
		http.csrf(customizer->customizer.disable());
		//http.formLogin(Customizer.withDefaults());
		http.authorizeHttpRequests(authorizeHttp->authorizeHttp
				.requestMatchers("add-newuser", "jwtlogin").permitAll().anyRequest().authenticated());
		//for /add-newuser API, we are permitting all users because it's like a signup page
		
		http.httpBasic(Customizer.withDefaults());
		// this code is good enough to make application stateless
		//http.sessionManagement
		//(session->session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));
		
		// this is for JWT filter
		
		http.sessionManagement
		(session->session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
		.addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class);
		return http.build();
	}
	
	// to decrypt passwords
	@Bean
	public AuthenticationProvider authProvider()
	{
		DaoAuthenticationProvider daoProvider = new DaoAuthenticationProvider();
		daoProvider.setUserDetailsService(userDetailsService);
		// daoProvider.setPasswordEncoder(NoOpPasswordEncoder.getInstance()); // this one is No password encoder
		daoProvider.setPasswordEncoder(new BCryptPasswordEncoder(12));
		return daoProvider;
		
	}
	
	@Bean
	public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception
	{
		return config.getAuthenticationManager();
	}

	
/* not needed in JWT authentication	
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

*/
}
