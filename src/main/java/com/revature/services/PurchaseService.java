package com.revature.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.models.CreditCard;
import com.revature.models.Item;
import com.revature.models.User;
import com.revature.repositories.CreditCardRepository;

@Service
public class PurchaseService {

	private CreditCardRepository doomDB;

	@Autowired
	public PurchaseService(CreditCardRepository doomDB) {
		super();
		this.doomDB = doomDB;
	}
	


	public void addCreditCard(CreditCard cc) {
		doomDB.save(cc);
		return;
		
	}



	public CreditCard getCreditCardByUser(User owner) {
		return doomDB.findByUser(owner);
	}


}
