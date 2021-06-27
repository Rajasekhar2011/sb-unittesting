package com.sb.unittesting.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sb.unittesting.model.Item;
import com.sb.unittesting.repoistory.ItemRepository;

@Service
public class ItemService {
	
	@Autowired
	private ItemRepository itemRepository;
	
	public Item getItems() {
		return new Item(2, "Iphone", 52000, 2);
	}
	
	public List<Item> getAllItems(){
		List<Item> allItems = itemRepository.findAll();
		for(Item i : allItems) {
			i.setValue(i.getPrice() * i.getQuantity());
		}
		
		return allItems;
	}
}
