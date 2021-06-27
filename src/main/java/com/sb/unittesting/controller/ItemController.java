package com.sb.unittesting.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sb.unittesting.model.Item;

@RestController
public class ItemController {

	@GetMapping("/items")
	public Item getItems() {
		return new Item(1, "Shirt", 1500, 1);
	}
}
