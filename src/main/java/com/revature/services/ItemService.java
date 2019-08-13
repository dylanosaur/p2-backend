package com.revature.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import com.revature.models.Item;
import com.revature.models.User;
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


	public void addItem(Item item) {
		doomDB.save(item);
		return;
	}

}
