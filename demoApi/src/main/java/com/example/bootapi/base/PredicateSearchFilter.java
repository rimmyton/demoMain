package com.example.bootapi.base;

import java.util.Arrays;
import java.util.List;

import com.google.common.collect.Lists;

public class PredicateSearchFilter {
	
	private SearchFilterOperator searchFilterOperator;
	private List<SearchFilter> searchFilters ;
	
	public PredicateSearchFilter() {
		super();
	}

	public PredicateSearchFilter(SearchFilterOperator searchFilterOperator,List<SearchFilter> searchFilters) {
		this.searchFilterOperator = searchFilterOperator;
		this.searchFilters = searchFilters;
	}
	
	public PredicateSearchFilter(SearchFilterOperator operator,SearchFilter... searchFilters) {
		this.searchFilterOperator = operator;
		this.searchFilters = Lists.newArrayList();
		this.searchFilters.addAll(Arrays.asList(searchFilters));
	}

	public SearchFilterOperator getSearchFilterOperator() {
		return searchFilterOperator;
	}

	public void setSearchFilterOperator(SearchFilterOperator searchFilterOperator) {
		this.searchFilterOperator = searchFilterOperator;
	}

	public List<SearchFilter> getSearchFilters() {
		return searchFilters;
	}


	
	
	
}
