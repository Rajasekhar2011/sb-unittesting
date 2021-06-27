package com.sb.unittesting.controller;

import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@WebMvcTest(ItemController.class )
@RunWith(SpringRunner.class)
public class ItemControllerTest {
	
	@Autowired
	private MockMvc mockMvc;

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

}
