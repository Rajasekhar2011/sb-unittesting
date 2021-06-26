package com.sb.unittesting.service;

import static org.junit.Assert.*;

import org.junit.Test;

public class ServiceImplTest {

	@Test
	public void test_calculateSum_positive() {
		ServiceImpl serviceImpl = new ServiceImpl();
		int[] initialArray = { 1, 2, 3, 4 };
		int actual = serviceImpl.calculateSum(initialArray);
		assertEquals(10, actual);
	}
	
	@Test
	public void test_calculateSum_emptyArray() {
		ServiceImpl serviceImpl = new ServiceImpl();
		int[] initialArray = new int[0];
		int actual = serviceImpl.calculateSum(initialArray);
		assertEquals(0, actual);
	}

}
