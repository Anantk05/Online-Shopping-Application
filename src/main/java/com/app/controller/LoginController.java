package com.app.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.app.exceptions.CustomerException;
import com.app.exceptions.UserException;
import com.app.login.CurrentUserSession;
import com.app.login.LoginException;
import com.app.model.User;
import com.app.service.LoginService;
@RestController
public class LoginController {
	
	
	@Autowired
	private LoginService loginService;
	
	@PostMapping("/users/login")
	public ResponseEntity<CurrentUserSession> addUser(@Valid @RequestBody User user) throws UserException, CustomerException {
		
		CurrentUserSession currentSession = loginService.addUser(user) ;
		
		return new ResponseEntity<CurrentUserSession>(currentSession,HttpStatus.CREATED) ;
	}
	
	@DeleteMapping("users/logout")
	public ResponseEntity<String> logoutUser(@RequestParam String key) throws UserException, LoginException {
		
		String response = loginService.signOut(key);
		
		return new ResponseEntity<String>(response,HttpStatus.OK) ;
		
	}
	
	
}












