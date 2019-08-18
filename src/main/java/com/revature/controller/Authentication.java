package com.revature.controller;

import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.auth0.jwt.JWT;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.revature.models.JwtContainer;
import com.revature.models.LoginRequest;
import com.revature.models.SignInResponse;
import com.revature.models.User;
import com.revature.models.UserUpdates;
import com.revature.services.UserService;

@RestController
@RequestMapping("users")
@CrossOrigin(origins = "http://localhost:3000", methods = {RequestMethod.POST, RequestMethod.PUT}, allowCredentials="true" )
public class Authentication {

	
	private UserService service;
	
	
	@Autowired
	public Authentication(UserService service) {
		super();
		this.service = service;
	}


	@PostMapping(path="/signin")
	public SignInResponse signIn(@RequestBody LoginRequest form, HttpServletResponse response) { 
		SignInResponse res = service.signIn(form, response);
		return res;
	}
	
	@PostMapping(path="/signup")
	@ResponseStatus(HttpStatus.CREATED)
	public Boolean signIn(@RequestBody User newUser) { 
		Boolean wasCreated = service.signUp(newUser);
		return wasCreated;
	}
	
	@PostMapping(path="/decode")
	public Integer decodeMyToken(@RequestBody JwtContainer token) { 
		String tokenString = token.getToken();
		DecodedJWT decodedJwt = JWT.decode(tokenString);
		Map<String, Claim> myClaims = decodedJwt.getClaims();
		Integer myInt = myClaims.get("userid").asInt();
		return myInt;
	}
	
	@PutMapping(path="/userinfo")
	public SignInResponse updateUser(@RequestBody UserUpdates userUpdates, @RequestHeader(value="Authorization") String myToken)  {
		System.out.println(myToken);
		int userid = JWT.decode(myToken).getClaims().get("userid").asInt();
		User myUser = userUpdates.getUser();
		myUser.setId(userid);
		System.out.println(userUpdates);
		SignInResponse myResponse = service.updateUser(userUpdates);
		return myResponse; 
	}
	
	
	
	
}
