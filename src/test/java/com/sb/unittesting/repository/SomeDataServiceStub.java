package com.sb.unittesting.repository;

import java.util.Arrays;
import java.util.List;

import com.sb.unittesting.repoistory.SomeDataService;

public class SomeDataServiceStub implements SomeDataService {

	@Override
	public List<Integer> retrieveAllData() {
		return Arrays.asList(1, 2, 3, 4, 5);
	}

}
