package com.example.bootapi.base;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.apache.commons.lang3.StringUtils;

import com.google.common.collect.Lists;
import com.google.common.collect.Sets;

/**
 * 功能说明：
 * 
 * @author liming
 * @Date 2016年4月27日
 * @version 2.5
 *
 */
public class SearchFilter {

	/**
	 * IN 的value 是 List集合(如：Arrays.asList(new Integer[]{1,2,3,4,5}))); 
	 * @author LM
	 *
	 */
	public enum Operator {
		EQ, NE, LIKE, GT, LT, GTE, LTE, IN, ISNULL, ISNOTNULL, ISEMPTY, ISNOTEMPTY, NOTIN
	}
	//GT大于  LT小于   GTE大于等于   LTE小于等于

	public String fieldName;
	public Object value;
	public Operator operator;

	public SearchFilter(String fieldName, Operator operator, Object value) {
		this.fieldName = fieldName;
		this.value = value;
		this.operator = operator;
	}

	public SearchFilter(String fieldName, Operator operator) {
		this.fieldName = fieldName;
		this.operator = operator;
	}

	/**
	 * searchParams中key的格式为OPERATOR_FIELDNAME
	 */
	public static List<SearchFilter> parse2(Map<String, Object> searchParams) {
		List<SearchFilter> filters = new ArrayList<SearchFilter>();

		for (Entry<String, Object> entry : searchParams.entrySet()) {
			// 过滤掉空值
			String key = entry.getKey();
			Object value = entry.getValue();
			if (StringUtils.isBlank(String.valueOf(value))) {
				continue;
			}

			// 拆分operator与filedAttribute
			String[] names = StringUtils.split(key, "_");
			if (names.length != 2) {
				throw new IllegalArgumentException(key + " is not a valid search filter name");
			}
			String filedName = names[1];
			Operator operator = Operator.valueOf(names[0]);

			// 创建searchFilter
			SearchFilter filter = new SearchFilter(filedName, operator, value);
			filters.add(filter);
		}

		return filters;
	}

	/**
	 * searchParams中key的格式为OPERATOR_FIELDNAME
	 */
	public static Set<SearchFilter> parse(Map<String, Object> searchParams) {
		Set<SearchFilter> filters = Sets.newHashSet();

		for (Entry<String, Object> entry : searchParams.entrySet()) {
			// 过滤掉空值
			String key = entry.getKey();
			Object value = entry.getValue();
			if (StringUtils.isBlank(String.valueOf(value))) {
				continue;
			}

			// 拆分operator与filedAttribute
			String[] names = StringUtils.split(key, "_");
			if (names.length != 2) {
				throw new IllegalArgumentException(key + " is not a valid search filter name");
			}
			String filedName = names[1];
			Operator operator = Operator.valueOf(names[0]);

			// 创建searchFilter
			SearchFilter filter = new SearchFilter(filedName, operator, value);
			filters.add(filter);
		}

		return filters;
	}
	
	/**
	 * searchParams中key的格式为OPERATOR_FIELDNAME_OPERATOR_FIELDNAME_OPERATOR_FIELDNAME......
	 */
	public static List<PredicateSearchFilter> parseAnto(Map<String, Object> searchParams) {
		List<SearchFilter> andFilters = Lists.newArrayList();
		List<PredicateSearchFilter> predicateSearchFilters = Lists.newArrayList();
		
		for (Entry<String, Object> entry : searchParams.entrySet()) {
			// 过滤掉空值
			String key = entry.getKey();
			Object value = entry.getValue();
			if (StringUtils.isBlank(String.valueOf(value))) {
				continue;
			}

			// 拆分operator与filedAttribute
			String[] names = StringUtils.split(key, "_");

			List<SearchFilter> orFilters;
			if(names.length > 2){
				orFilters = Lists.newArrayList();
				predicateSearchFilters.add(new PredicateSearchFilter(SearchFilterOperator.OR, orFilters));
				for (int i = 0; i < names.length; i++) {
					Operator operator = Operator.valueOf(names[i++]);//operator
					String filedName = names[i];//filedAttribute
					
					SearchFilter filter = new SearchFilter(filedName, operator, value);
					orFilters.add(filter);
				}
			}else{
				Operator operator = Operator.valueOf(names[0]);
				String filedName = names[1];

				SearchFilter filter = new SearchFilter(filedName, operator, value);
				andFilters.add(filter);
			}
		}
		predicateSearchFilters.add(new PredicateSearchFilter(SearchFilterOperator.AND, andFilters));
		
		return predicateSearchFilters;
	}
	
}
