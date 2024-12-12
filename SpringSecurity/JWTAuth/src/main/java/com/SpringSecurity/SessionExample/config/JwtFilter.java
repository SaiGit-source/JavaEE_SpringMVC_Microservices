package com.SpringSecurity.SessionExample.config;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.SpringSecurity.SessionExample.service.JwtTokenService;
import com.SpringSecurity.SessionExample.service.MyUserDetailsService;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class JwtFilter extends OncePerRequestFilter {
	
	@Autowired
	private JwtTokenService service;
	
	@Autowired
	private MyUserDetailsService userService;

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		
		String authHeader = request.getHeader("Authorization");
		String token = null;
		String usrname = null;
		if (authHeader!=null && authHeader.startsWith("Bearer ")) {
			// the token starts with the Bearer
			token = authHeader.substring(7);// substring from index 7 to end
			usrname = service.extractUserName(token);
		}
		
		if (usrname!=null && SecurityContextHolder.getContext().getAuthentication()==null) {
			// fetch userDetails from DB
			UserDetails userDetails = userService.loadUserByUsername(usrname);// returns UserDetails object of the user if found in users database
			Boolean status = service.validateToken(token, userDetails);
			if (status) {
				UsernamePasswordAuthenticationToken authToken = 
						new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
				authToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
				System.out.println("JwtFilter: authToken: "+authToken);
				SecurityContextHolder.getContext().setAuthentication(authToken);
			}
		}
		filterChain.doFilter(request, response);

	}

}
