package com.sb.unittesting.service;

import java.util.List;
import java.util.function.Function;

import com.sb.unittesting.repoistory.SomeDataService;

public class ServiceImpl {

	SomeDataService someDataService;

	public void setSomeDataService(SomeDataService someDataService) {
		this.someDataService = someDataService;
	}

	public int calculateSum(int[] arr) {
		Function<int[], Integer> sumFunction = intArray -> {
			int sum = 0;
			for (int i : intArray) {
				sum = sum + i;
			}
			return sum;
		};

		return sumFunction.apply(arr);
	}

	public int calculateSumUsingDataService() {
		int sum = 0;
		List<Integer> data = someDataService.retrieveAllData();
		for (int item : data) {
			sum = sum + item;
		}
		return sum;
	}

}
