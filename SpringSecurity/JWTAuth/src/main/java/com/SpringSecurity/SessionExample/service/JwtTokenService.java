package com.SpringSecurity.SessionExample.service;

import java.security.Key;
import java.util.Base64;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;

@Service
public class JwtTokenService {
	
	//private String secretKey="randomSecret"; // this is also correct but not recommended

	private String secretKey;

	public JwtTokenService() {
		this.secretKey = getSecretKey(); // secretKey for token generation
	}
	
	private String getSecretKey() {
		try
		{
			KeyGenerator key = KeyGenerator.getInstance("HmacSHA256");
			SecretKey secret = key.generateKey();
			return Base64.getEncoder().encodeToString(secret.getEncoded());
		}
		catch(Exception e)
		{
			throw new RuntimeException("Error is generating key");
		}
		
	}

	
	// Part 1: Generation of JWT
	
	public String generateToken(String name) {
		Map<String, Object> claims = new HashMap<>();
		return Jwts.builder()
				.setClaims(claims)
				.setSubject(name)
				.setIssuedAt(new Date(System.currentTimeMillis()))
				.setExpiration(new Date(System.currentTimeMillis()+180000000)) // random constant time for the token expiration
				.signWith(getKey(), SignatureAlgorithm.HS256)
				.compact();
	}
	
	private Key getKey() {
		byte[] b = Decoders.BASE64.decode(secretKey);
		return Keys.hmacShaKeyFor(b);
	}
	

	
	// Part 2: verification of JWT
	// extract username from token, for that first we got to extract Claim
	public String extractUserName(String token) {
		return extractClaim(token, Claims::getSubject);
	}
	
	private <T> T extractClaim(String token, Function<Claims, T> claimResolver) {
		System.out.println("extractClaim: Token in extract claim "+token);
		final Claims claims = extractAllClaims(token);
		System.out.println("extractClaim Claims "+claims);
		return claimResolver.apply(claims);
	}

	private Claims extractAllClaims(String token) {
		System.out.println("extractAllClaims: Token "+token);
		return Jwts.parserBuilder()
				.setSigningKey(getKey())
				.build().parseClaimsJws(token)
				.getBody();
	}
	
	
	// once token is extracted, it needs to be validated
	// we pass in userDetails, which is returned from database.
	public boolean validateToken(String token, UserDetails userDetails) {
		final String userName = extractUserName(token);
		System.out.println("validateToken: extracted userName "+userName);
		return (userName.equals(userDetails.getUsername()) && !isTokenExpired(token));
	}
	
    private boolean isTokenExpired(String token) {
    	System.out.println("isTokenExpired: token");
        return extractExpiration(token).before(new Date()); // we return true if it is before current Date() 
    }
    
    private Date extractExpiration(String token) {
        return extractClaim(token, Claims::getExpiration);
        // we return token expiration
    }
}
