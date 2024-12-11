package com.SpringSecurity.OAuthApp.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/*
 * say you want to visit a 3rd party application, based on the info from 3rd party API, we give access to users accordingly. you want to register using 3rd party API like Google, Facebook, etc. thats when we need OAuth2.0. Add dependency OAuth2 -> Client, Spring Web. In OAuth2 by default, we are getting Spring Security login page. the class we got to disturb is SecurityFilterChain. Go to Google console -> console.cloud.google.com -> create OAuth client ID -> Add URI -> copy Client ID, Client secret. Set oauth2.registration.google.client.id in application.properties, same for client secret. if you enter the API endpoint in browser then it will redirect to Google login page. if you want to signin with Github, then do the same thing. github.com/settings/application

 */

@RestController
public class LoginController {
	
	@GetMapping("/loginPage")
	public String getWelcome() {
		return "You have successfully logged-in and Welcome!";
	}

}
