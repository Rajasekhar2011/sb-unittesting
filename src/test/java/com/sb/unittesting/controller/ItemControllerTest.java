package com.sb.unittesting.controller;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Arrays;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.sb.unittesting.model.Item;
import com.sb.unittesting.service.ItemService;

@WebMvcTest(ItemController.class )
@RunWith(SpringRunner.class)
public class ItemControllerTest {
	
	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private ItemService itemService;

	@Test
	public void test_Items() throws Exception {
			
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/items")
															.accept(MediaType.APPLICATION_JSON);
		MvcResult mvcResult =  mockMvc.perform(requestBuilder)
									 .andExpect(status().isOk())
									 //.andExpect(content().string("{\"id\":1,\"name\":\"Shirt\",\"price\":1500,\"quantity\":1}"))
									 .andExpect(content().json("{\"id\": 1,\"name\":\"Shirt\",\"price\":1500}"))
									 .andReturn();
		
	}
	
	@Test
	public void test_ItemsByMockingService() throws Exception {
		
		when(itemService.getItems()).thenReturn(new Item (1, "iphone",56000, 2));
			
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/items-service")
															.accept(MediaType.APPLICATION_JSON);
		MvcResult mvcResult =  mockMvc.perform(requestBuilder)
									 .andExpect(status().isOk())
									 .andExpect(content().json("{id: 1,name:iphone,price:56000,quantity:2}"))
									 .andReturn();
		
	}
	
	
	
	@Test
	public void test_ItemsByMockingServiceGettingDetailsFromDb() throws Exception {
		
		when(itemService.getAllItems()).thenReturn(Arrays.asList(new Item (1, "iphone",56000, 2)));
			
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/getallitems-from-database")
															.accept(MediaType.APPLICATION_JSON);
		MvcResult mvcResult =  mockMvc.perform(requestBuilder)
									 .andExpect(status().isOk())
									 .andExpect(content().json("[{id: 1,name:iphone,price:56000,quantity:2}]"))
									 .andReturn();
		
	}


}
