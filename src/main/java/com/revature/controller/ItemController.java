package com.revature.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.models.Item;
import com.revature.services.ItemService;

@RestController
@RequestMapping(path = "items")
public class ItemController {

	private ItemService service;

	@Autowired
	public ItemController(ItemService service) {
		super();
		this.service = service;
	}

	@CrossOrigin
	@GetMapping(path = "/{id}")
	Item getItemById(@PathVariable int id) {
		return service.getItemById(id);
	}
	
	@CrossOrigin
	@GetMapping(path = "/")
	List<Item> getAllItems() {
		return service.getAllItems();
	}

	@PostMapping(path = "/")
	public Item postItem(@RequestBody Item item) {
		service.addItem(item);
		return item;
	}
	
	@GetMapping(path="/type/{type}")
	List<Item> getItemByType(@PathVariable String type) { 
		List<Item> items = service.getAllItemsByType(type);
		return items;
	}

}
