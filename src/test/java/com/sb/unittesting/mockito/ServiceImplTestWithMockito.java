package com.sb.unittesting.mockito;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.Arrays;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.sb.unittesting.repoistory.SomeDataService;
import com.sb.unittesting.service.ServiceImpl;

@RunWith(MockitoJUnitRunner.class)
public class ServiceImplTestWithMockito {

	/*
	 * ServiceImpl si = new ServiceImpl();
	 *  //mock method to mock the interfaces so that it creates instance of it 
	 * SomeDataService sds = mock(SomeDataService.class);
	 */
	
	@Mock
	SomeDataService sds;
	
	@InjectMocks
	ServiceImpl si;

	@Test
	public void test_calculateSumUsingMockito() {
		si.setSomeDataService(sds);
		when(sds.retrieveAllData()).thenReturn(Arrays.asList(1, 2, 3, 4, 5));
		assertEquals(15, si.calculateSumUsingDataService());
	}

	@Test
	public void test_calculateSumUsingMockito_returningEmptyArray() {
		si.setSomeDataService(sds);
		when(sds.retrieveAllData()).thenReturn(Arrays.asList());
		assertEquals(0, si.calculateSumUsingDataService());
	}

}
