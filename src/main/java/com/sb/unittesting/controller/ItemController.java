package com.sb.unittesting.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sb.unittesting.model.Item;
import com.sb.unittesting.service.ItemService;

@RestController
public class ItemController {
	
	@Autowired
	private ItemService itemService;

	@GetMapping("/items")
	public Item getItems() {
		return new Item(1, "Shirt", 1500, 1);
	}
	
	@GetMapping("/items-service")
	public Item getItemsFromService() {
		return itemService.getItems();
	}
	
	@GetMapping("/getallitems-from-database")
	public List<Item> retriveAllItemsFromDB(){
		return itemService.getAllItems();
	}
}
