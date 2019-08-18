package com.revature.services;

import java.util.Optional;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.revature.models.CreditCard;
import com.revature.models.LoginRequest;
import com.revature.models.SignInResponse;
import com.revature.models.User;
import com.revature.models.UserUpdates;
import com.revature.repositories.CreditCardRepository;
import com.revature.repositories.UserRepository;

@Service
public class UserService {

	
	private UserRepository doomDB;
	private CreditCardRepository creditCardRepository;

	@Autowired 
	public UserService(UserRepository doomDB, CreditCardRepository creditCardRepository) {
		super();
		this.doomDB = doomDB;
		this.creditCardRepository = creditCardRepository;
	}

	
	// sign-in
	public SignInResponse signIn(LoginRequest form, HttpServletResponse response) {
		//User myUser = new User(form.getEmail(), form.getPassword());
		User myUser = this.doomDB.findByUsername(form.getUsername());
		try {
		    Algorithm algorithm = Algorithm.HMAC256("bruce-wayne-is-batman");
		    String token = JWT.create()
		        .withIssuer("auth0")
		        .withClaim("userid", myUser.getId())
		        .sign(algorithm);
		    // add token to header
			myUser.setToken(token);
		    //return token;
		} catch (JWTCreationException exception){
		    //Invalid Signing configuration / Couldn't convert Claims.
		}
		CreditCard myCreditCard = this.creditCardRepository.findByUserid(myUser.getId());
		SignInResponse mySignInResponse = new SignInResponse(myCreditCard, myUser);
		return mySignInResponse;
	}

	// sign-up
	public Boolean signUp(User user) {
		User createdUser = this.doomDB.save(user);
		CreditCard newCard = new CreditCard();
		System.out.println(createdUser);

		newCard.setUserid(createdUser.getId());
		
		this.creditCardRepository.save(newCard);
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


	public SignInResponse updateUser(UserUpdates myUserUpdates) {
		User userUpdates = myUserUpdates.getUser();
		CreditCard ccUpdates = myUserUpdates.getCreditCard();
		User myUser = doomDB.findById(userUpdates.getId());
		myUser.setEmail(userUpdates.getEmail());
		myUser.setFirstName(userUpdates.getFirstName());
		myUser.setLastName(userUpdates.getLastName());
		myUser.setUsername(userUpdates.getUsername());
		myUser.setPassword(userUpdates.getPassword());
		CreditCard myCreditCard = creditCardRepository.findByUserid(userUpdates.getId());
		myCreditCard.setAddress(ccUpdates.getAddress());
		myCreditCard.setExpiration(ccUpdates.getExpiration());
		myCreditCard.setNumber(ccUpdates.getNumber());
		myCreditCard.setSecurityCode(ccUpdates.getSecurityCode());
		creditCardRepository.saveAndFlush(myCreditCard);
		User updatedUser = doomDB.saveAndFlush(myUser);
		SignInResponse mySignInResponse = new SignInResponse(myCreditCard, updatedUser);
		return mySignInResponse;
	}
	
	
}
