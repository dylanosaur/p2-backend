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

import com.revature.models.Order;
import com.revature.services.OrderService;

@RestController
@CrossOrigin(origins = "http://localhost:3000", methods = {RequestMethod.POST, RequestMethod.GET})
@RequestMapping(path = "orders")
public class OrderController {
	
	private OrderService service;

	@Autowired
	public OrderController(OrderService service) {
		super();
		this.service = service;
	}

	@GetMapping(path = "/")
	List<Order> getAllOrders() {
		return service.getAllOrders();
	}

	@PostMapping(path = "/")
	Order postOrder(@RequestBody Order order) {
		service.addOrder(order);
		return order;
	}
	
	@GetMapping(path = "/{id}")
	Order getOrderById(@PathVariable int id) {
		return service.getOrderById(id);
	}

	
	@GetMapping(path="/user/{user}")
	List<Order> getOrdersByUser(@PathVariable int user) { 
		List<Order> orders = service.getAllOrdersByUser(user);
		return orders;
	}


}
