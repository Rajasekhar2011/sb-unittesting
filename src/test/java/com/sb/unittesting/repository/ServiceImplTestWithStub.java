package com.sb.unittesting.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;

import com.sb.unittesting.service.ServiceImpl;

public class ServiceImplTestWithStub {
	
	ServiceImpl si = new ServiceImpl();
	
	@Test
	public void test_calculateSumUsingDataService() {
		si.setSomeDataService(new SomeDataServiceStub());
		
		assertEquals(15, si.calculateSumUsingDataService());
	}

}
