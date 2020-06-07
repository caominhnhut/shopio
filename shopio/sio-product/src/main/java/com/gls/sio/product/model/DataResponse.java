package com.gls.sio.product.model;

public class DataResponse<T> {

	private T data;
	private String errorMessage;
	
	public DataResponse()
	{
		
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
}
