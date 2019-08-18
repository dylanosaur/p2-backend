package com.revature.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.revature.models.Item;
import com.revature.models.User;
import com.revature.services.CartService;
import com.revature.services.UserService;

@RestController 
@RequestMapping("cart")
@CrossOrigin(allowedHeaders = "*", 
	methods = {
			RequestMethod.POST,
			RequestMethod.DELETE,
			RequestMethod.GET
	})
public class CartController {

	private CartService service;
	private UserService userService;

	@Autowired 
	public CartController(CartService service, UserService userService) {
		super();
		this.service = service;
		this.userService = userService;
	}

//	
//	// add item to cart
//	@PostMapping(path="/{userid}/item/{itemid}")
//	public void addItemToCart(@PathVariable int userid, @PathVariable int itemid) { 
//		User owner = userService.findById(userid);
//		System.out.println(owner);
//		Item newItem = service.findById(itemid);
//		owner.addToCart(newItem);
//		System.out.println(owner.getCart());
//		userService.save(owner);
//		System.out.println(owner);
//	}
//	
//	// get cart
//	@GetMapping(path="/{userid}")
//	public List<Item> getCart(@PathVariable int userid) {
//		User owner = userService.findById(userid);
//		System.out.println(owner);
//		return owner.getCart();
//	}
//
//	
	
	// remove item from cart
	
	// get all items in cart for user id
	
	
	
}
