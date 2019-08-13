//package com.revature.controller;
//
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.CrossOrigin;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.revature.models.Item;
//import com.revature.services.CartService;
//
//@RestController 
//@RequestMapping("cart")
//@CrossOrigin(allowedHeaders = "*", 
//	methods = {
//			RequestMethod.POST,
//			RequestMethod.DELETE,
//			RequestMethod.GET
//	})
//public class CartController {
//
//	private CartService service;
//
//	@Autowired 
//	public CartController(CartService service) {
//		super();
//		this.service = service;
//	} 
//	
//	
////	// add item to cart
////	@PostMapping(path="{userid}")
////	public List<Item> addItemToCart(@PathVariable int userid, @RequestBody Item item) {
////		List<Item> cart = service.findByUser(userid);
////		return cart;
////	}
////	
//	
//	// remove item from cart
//	
//	// get all items in cart for user id
//	
//	
//	
//}
