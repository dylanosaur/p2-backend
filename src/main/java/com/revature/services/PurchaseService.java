package com.revature.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.models.DoomRepository;

@Service
public class PurchaseService {

	DoomRepository doomDB;

	@Autowired
	public PurchaseService(DoomRepository doomDB) {
		super();
		this.doomDB = doomDB;
	}

}
