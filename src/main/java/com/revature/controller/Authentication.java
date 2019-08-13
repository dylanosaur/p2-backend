package com.revature.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.revature.models.LoginRequest;
import com.revature.models.User;
import com.revature.services.UserService;

@RestController
@RequestMapping("users")
@CrossOrigin(allowedHeaders = "*", methods = {RequestMethod.POST})
public class Authentication {

	
	private UserService service;
	
	
	@Autowired
	public Authentication(UserService service) {
		super();
		this.service = service;
	}


	@PostMapping(path="/signin")
	public User signIn(@RequestBody LoginRequest form) { 
		User user = service.signIn(form);
		return user;
	}
	
	@PostMapping(path="/signup")
	@ResponseStatus(HttpStatus.CREATED)
	public Boolean signIn(@RequestBody User newUser) { 
		Boolean wasCreated = service.signUp(newUser);
		return wasCreated;
	}
	
	
	
	
}
