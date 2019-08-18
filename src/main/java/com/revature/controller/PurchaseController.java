package com.revature.controller;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException;

import com.revature.models.CreditCard;
import com.revature.models.Item;
import com.revature.models.User;
import com.revature.services.PurchaseService;
import com.revature.services.UserService;

@RestController
@RequestMapping("purchase")
@CrossOrigin(allowedHeaders = "*", methods = {RequestMethod.POST})
public class PurchaseController {

	
	
	

	/**
	 * @ResponseBody - Tells Spring that the returned value does NOT represent a
	 *               template view, but instead is itself the body of the response
	 * @GetMapping - Handles get request with the added string context
	 * @PostMapping
	 * @PutMapping
	 * @DeleteMapping
	 * @PatchMapping
	 * @RequestMapping - (Handle any kind of request)
	 * @return
	 */

	
	
	private PurchaseService service;
	public UserService userService;
	
	@Autowired
	public PurchaseController(PurchaseService service, UserService userService) {
		super();
		this.service = service;
		this.userService = userService;
	}

	@PostMapping(path="/creditcard/userid/{id}")
	void addCreditCard(@PathVariable int id, @RequestBody CreditCard cc) { 
		service.addCreditCard(cc);
		return;
	}
	
//	@GetMapping(path="/creditcard/userid/{id}")
//	CreditCard getCreditCard(@PathVariable int id) { 
//		User owner = userService.findById(id);
//		return service.getCreditCardByUser(owner);
//		
//	}
	

	@ExceptionHandler(HttpClientErrorException.class)
	public ResponseEntity<String> errorHandler(HttpClientErrorException e) {
		return ResponseEntity.status(e.getStatusCode()).body(e.getMessage());
	}
	
}
	