package com.revature.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import com.revature.models.DoomRepository;
import com.revature.models.LoginRequest;
import com.revature.models.User;

@Service
public class AuthenticationService {

	
	private DoomRepository doomDB;

	@Autowired 
	public AuthenticationService(DoomRepository doomDB) {
		super();
		this.doomDB = doomDB;
	}
	// sign-in
	public User signIn(LoginRequest form) {
		//User myUser = new User(form.getEmail(), form.getPassword());
		User myUser = this.doomDB.findByEmail(form.getEmail());
		return myUser;
	}


	// sign-up
	public Boolean signUp(User user) {
		this.doomDB.save(user);
		Example<User> ex = Example.of(user); 
		Boolean wasCreated = this.doomDB.exists(ex);
		return wasCreated;
		
	
	}
}
