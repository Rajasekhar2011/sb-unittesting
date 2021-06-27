package com.sb.unittesting.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.sb.unittesting.model.Item;
import com.sb.unittesting.repoistory.ItemRepository;

@RunWith(MockitoJUnitRunner.class)
public class ItemServiceTest {

	@InjectMocks
	ItemService itemService;  
	
	@Mock
	ItemRepository itemRepository;
	
	@Test
	public void test_getAllItems() {
		when(itemRepository.findAll()).thenReturn(Arrays.asList(new Item(1, "Iphone", 70000, 2),new Item(2, "Googlepixel", 35000, 1)));
		List<Item> allItems= itemService.getAllItems();
		assertEquals(140000, allItems.get(0).getValue());
		assertEquals(35000, allItems.get(1).getValue());
	}

}
