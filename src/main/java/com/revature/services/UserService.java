package com.revature.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.revature.models.LoginRequest;
import com.revature.models.User;
import com.revature.repositories.UserRepository;

@Service
public class UserService {

	
	private UserRepository doomDB;

	@Autowired 
	public UserService(UserRepository doomDB) {
		super();
		this.doomDB = doomDB;
	}

	
	// sign-in
	public String signIn(LoginRequest form) {
		//User myUser = new User(form.getEmail(), form.getPassword());
		User myUser = this.doomDB.findByUsername(form.getUsername());
		try {
		    Algorithm algorithm = Algorithm.HMAC256("secret");
		    String token = JWT.create()
		        .withIssuer("auth0")
		        .withClaim("userid", myUser.getId())
		        .sign(algorithm);
		    return token;
		} catch (JWTCreationException exception){
		    //Invalid Signing configuration / Couldn't convert Claims.
		}
		return "";
	}

	// sign-up
	public Boolean signUp(User user) {
		this.doomDB.save(user);
		Example<User> ex = Example.of(user); 
		Boolean wasCreated = this.doomDB.exists(ex);
		return wasCreated;
		
	
	}


	public User findById(int id) {
		User myUser = doomDB.findById(id);
		return myUser;
	}


	public void save(User user) {
		doomDB.save(user);
		return;
		// TODO Auto-generated method stub
		
	}
	
	
}
