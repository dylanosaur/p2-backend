package com.revature.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.models.Item;
import com.revature.models.User;
import com.revature.repositories.ItemRepository;

@Service
public class CartService {

	private ItemRepository itemRepository;

	
	@Autowired 
	public CartService(ItemRepository itemRepository) {
		super();
		this.itemRepository = itemRepository;
	}

	public List<Item> findByUser(User user) {
		List<Item> cart = itemRepository.findAllByUser(user);
		return cart;
	}

	public Item findById(int itemid) {
		Item myItem = itemRepository.findById(itemid);
		return myItem;
	} 
	
	// add item to cart
	
	
	

	// remove item from cart
	
	// get all items in cart for user id
	
	
	
	
	
}
