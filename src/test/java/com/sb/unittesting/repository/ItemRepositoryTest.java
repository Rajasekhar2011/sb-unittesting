package com.sb.unittesting.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.sb.unittesting.model.Item;
import com.sb.unittesting.repoistory.ItemRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace=AutoConfigureTestDatabase.Replace.NONE)
public class ItemRepositoryTest {
	
	@Autowired
	ItemRepository itemRepository;

	@Test
	public void test_findAll() {
		List<Item> allItems = itemRepository.findAll();
		assertEquals(4, allItems.size());
	}

}
