package com.revature.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.models.Item;
import com.revature.repositories.ItemRepository;

@Service
public class ItemService {

	private ItemRepository doomDB;

	@Autowired
	public ItemService(ItemRepository doomDB) {
		super();
		this.doomDB = doomDB;
	}

	public Item getItemById(int id) {
		return doomDB.findById(id);
	}
	
	public List<Item> getAllItems() {
		return doomDB.findAll();
	}


	public void addItem(Item item) {
		doomDB.save(item);
		return;
	}

	public List<Item> getAllItemsByType(String type) {
		return doomDB.findAllByClothingType(type);
	}

}
