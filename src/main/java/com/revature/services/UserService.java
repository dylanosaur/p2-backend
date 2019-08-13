package com.revature.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

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
