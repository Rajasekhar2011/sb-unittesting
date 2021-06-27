package com.sb.unittesting.mockito;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
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
	
	@Test
	public void verificationBasics_negative() {
		si.setSomeDataService(sds);
		when(sds.retrieveAllData()).thenReturn(Arrays.asList(1, 2, 3, 4, 5));
		si.calculateSumUsingDataService();
		verify(sds, never()).storeData(15);
	}
	
	@Test
	public void verificationBasics_positive() {
		si.setSomeDataService(sds);
		when(sds.retrieveAllData()).thenReturn(Arrays.asList(1, 2, 3, 4, 2));
		si.calculateSumUsingDataService();
		verify(sds, times(1)).storeData(12);
	}
	
	@Test
	public void arguementCaptures() {
		si.setSomeDataService(sds);
		when(sds.retrieveAllData()).thenReturn(Arrays.asList(1, 2, 3, 4, 2));
		si.calculateSumUsingDataService();
		ArgumentCaptor<Integer> captor = ArgumentCaptor.forClass(Integer.class);
		verify(sds).storeData(captor.capture());
		assertEquals(new Integer(12), captor.getValue());
	}

}
