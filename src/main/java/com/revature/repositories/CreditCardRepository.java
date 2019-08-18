package com.revature.repositories;

import org.springframework.stereotype.Repository;

import com.revature.models.CreditCard;
import com.revature.models.User;

import org.springframework.data.jpa.repository.JpaRepository;


@Repository
public interface CreditCardRepository extends JpaRepository<CreditCard, Integer>{


//	CreditCard findByUser(User owner);

	CreditCard findByUserid(int userid);
	
	
}
