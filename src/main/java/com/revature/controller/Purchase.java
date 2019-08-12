package com.revature.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException;

import com.revature.services.PurchaseService;

@RestController
@RequestMapping("purchase")
@CrossOrigin(allowedHeaders = "*", methods = {RequestMethod.POST})
public class Purchase {

	private PurchaseService purchaseService;
	
	

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

	@Autowired
	public Purchase(PurchaseService purchaseService) {
		super();
		this.purchaseService = purchaseService;
	}

	// get all items in cart
	@GetMapping(path = "/cart/{id}", produces = "application/json")
	public String sayHello(@PathVariable int id) {
		String myString = "Hello " + id;
		return myString;
	}
	
	// add item to cart
	@PostMapping(path="/cart/{id}")
	
	
	

	@ExceptionHandler(HttpClientErrorException.class)
	public ResponseEntity<String> errorHandler(HttpClientErrorException e) {
		return ResponseEntity.status(e.getStatusCode()).body(e.getMessage());
	}
	
}
	