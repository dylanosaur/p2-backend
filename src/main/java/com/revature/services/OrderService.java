package com.revature.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.models.Order;
import com.revature.repositories.OrderRepository;

@Service
public class OrderService {

	private OrderRepository doomDB;
	
	@Autowired
	public OrderService(OrderRepository doomDB) {
		super();
		this.doomDB = doomDB;
	}

	public Order getOrderById(int id) {
		return doomDB.findById(id);
	}


	public Order addOrder(Order order) {
		doomDB.save(order);
		return order;
	}

	public List<Order> getAllOrdersByUser(int user) {
		return doomDB.findAllByUser(user);
	}

	public List<Order> getAllOrders() {
		return doomDB.findAll();
	}

}
