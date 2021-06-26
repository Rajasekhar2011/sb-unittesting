package com.sb.unittesting.mockito;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.Arrays;

import org.junit.Test;

import com.sb.unittesting.repoistory.SomeDataService;
import com.sb.unittesting.service.ServiceImpl;

public class ServiceImplTestWithMockito {

	ServiceImpl si = new ServiceImpl();
	SomeDataService sds = mock(SomeDataService.class);

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
