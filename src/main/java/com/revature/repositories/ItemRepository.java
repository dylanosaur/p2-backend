package com.revature.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.revature.models.Item;
import com.revature.models.User;

public interface ItemRepository extends JpaRepository<Item, Integer> {
	
	Item findById(int id);

	List<Item> findAllByUser(User user);

	List<Item> findAllByClothingType(String type);

}
