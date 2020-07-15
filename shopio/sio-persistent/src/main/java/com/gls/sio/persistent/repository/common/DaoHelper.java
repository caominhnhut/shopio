package com.gls.sio.persistent.repository.common;

import java.util.List;
import java.util.function.Function;

import javax.persistence.criteria.Predicate;

import com.google.common.base.Strings;

public final class DaoHelper {

	public static final int DEFAULT_LIMIT = 20;
	public static final int DEFAULT_OFFSET = 1;
	
	private DaoHelper() {
		// hide constructor
	}

	public static void addPredicateWithString(String input, List<Predicate> predicates, Function<String, Predicate> callback) {
		if (Strings.isNullOrEmpty(input)) {
			return;
		}
		
		predicates.add(callback.apply(input));
	}
	
	public static void addPredicateWithLong(Long input, List<Predicate> predicates, Function<Long, Predicate> callback) {
		if (input == null) {
			return;
		}
		
		predicates.add(callback.apply(input));
	}

	public static String encloseWithWildCard(String value) {
		return "%" + value + "%";
	}
}
