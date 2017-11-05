package com.exception;

public class InvalidRomanNumberException extends RuntimeException {

	public InvalidRomanNumberException() {}
	
	public InvalidRomanNumberException(final String message) {
		super(message);
	}
	
	private static final long serialVersionUID = -8728016381084391312L;
}
