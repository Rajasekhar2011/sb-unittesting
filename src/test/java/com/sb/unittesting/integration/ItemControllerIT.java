package com.sb.unittesting.integration;

import static org.junit.jupiter.api.Assertions.*;

import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
class ItemControllerIT {
	
	@Autowired
	private TestRestTemplate restTemplate;

	@Test
	void test_integration() throws JSONException {
		 String reponse =  this.restTemplate.getForObject("/getallitems-from-database", String.class);
		 JSONAssert.assertEquals("[{id:10000},{id:10001},{id:10002},{id:10003}]", reponse, false);
	}

}
