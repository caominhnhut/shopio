package com.gls.sio.persistent.exception;

public class ShopIOException extends RuntimeException {

	public ShopIOException(String errorMessage, Throwable e) {
		super(errorMessage, e);
	}
}
