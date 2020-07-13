package com.gls.sio.console.validator;

import java.util.Map;

import org.apache.commons.collections.map.HashedMap;

public class Errors {

	private Map<String, String> errors;
	
	public Errors()
	{
		this.errors = new HashedMap();
	}

	public Map<String, String> getErrors() {
		return errors;
	}
}
